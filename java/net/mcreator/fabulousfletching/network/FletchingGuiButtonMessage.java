
package net.mcreator.fabulousfletching.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.fabulousfletching.world.inventory.FletchingGuiMenu;
import net.mcreator.fabulousfletching.procedures.ToggleRecipeBookProcedure;
import net.mcreator.fabulousfletching.procedures.DecreasePageProcedure;
import net.mcreator.fabulousfletching.procedures.AdvancePageProcedure;
import net.mcreator.fabulousfletching.FabulousfletchingMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record FletchingGuiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<FletchingGuiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(FabulousfletchingMod.MODID, "fletching_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FletchingGuiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FletchingGuiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new FletchingGuiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<FletchingGuiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final FletchingGuiButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = FletchingGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ToggleRecipeBookProcedure.execute(entity);
		}
		if (buttonID == 1) {

			AdvancePageProcedure.execute(entity);
		}
		if (buttonID == 2) {

			DecreasePageProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		FabulousfletchingMod.addNetworkMessage(FletchingGuiButtonMessage.TYPE, FletchingGuiButtonMessage.STREAM_CODEC, FletchingGuiButtonMessage::handleData);
	}
}
