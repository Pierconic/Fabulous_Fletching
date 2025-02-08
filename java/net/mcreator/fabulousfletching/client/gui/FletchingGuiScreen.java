package net.mcreator.fabulousfletching.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.fabulousfletching.world.inventory.FletchingGuiMenu;
import net.mcreator.fabulousfletching.procedures.Tooltip4ConditionProcedure;
import net.mcreator.fabulousfletching.procedures.Tooltip3ConditionProcedure;
import net.mcreator.fabulousfletching.procedures.Tooltip2ConditionProcedure;
import net.mcreator.fabulousfletching.procedures.Tooltip1ConditionProcedure;
import net.mcreator.fabulousfletching.procedures.RecipePage2DisplayProcedure;
import net.mcreator.fabulousfletching.procedures.RecipePage1DisplayProcedure;
import net.mcreator.fabulousfletching.procedures.RecipeBookOpenProcedure;
import net.mcreator.fabulousfletching.procedures.DisplayTippedArrowRecipeProcedure;
import net.mcreator.fabulousfletching.procedures.DisplayJeweledArrowRecipeProcedure;
import net.mcreator.fabulousfletching.procedures.DisplayIronArrowRecipeProcedure;
import net.mcreator.fabulousfletching.procedures.DisplayGoldArrowRecipeProcedure;
import net.mcreator.fabulousfletching.procedures.DisplayForgedArrowRecipeProcedure;
import net.mcreator.fabulousfletching.procedures.DisplayFlintArrowRecipeProcedure;
import net.mcreator.fabulousfletching.network.FletchingGuiButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FletchingGuiScreen extends AbstractContainerScreen<FletchingGuiMenu> {
	private final static HashMap<String, Object> guistate = FletchingGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_guirecipebookoff;
	ImageButton imagebutton_arrowrightup;
	ImageButton imagebutton_arrowleftup;

	public FletchingGuiScreen(FletchingGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("fabulousfletching:textures/screens/fletching_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (Tooltip1ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 43 && mouseX < leftPos + 67 && mouseY > topPos + 49 && mouseY < topPos + 73)
				guiGraphics.renderTooltip(font, Component.translatable("gui.fabulousfletching.fletching_gui.tooltip_insert_feather"), mouseX, mouseY);
		if (Tooltip2ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 67 && mouseX < leftPos + 91 && mouseY > topPos + 49 && mouseY < topPos + 73)
				guiGraphics.renderTooltip(font, Component.translatable("gui.fabulousfletching.fletching_gui.tooltip_insert_stick"), mouseX, mouseY);
		if (Tooltip3ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 91 && mouseX < leftPos + 115 && mouseY > topPos + 49 && mouseY < topPos + 73)
				guiGraphics.renderTooltip(font, Component.translatable("gui.fabulousfletching.fletching_gui.tooltip_insert_tip_material"), mouseX, mouseY);
		if (Tooltip4ConditionProcedure.execute(entity))
			if (mouseX > leftPos + 92 && mouseX < leftPos + 116 && mouseY > topPos + 25 && mouseY < topPos + 49)
				guiGraphics.renderTooltip(font, Component.translatable("gui.fabulousfletching.fletching_gui.tooltip_potion_dye_or_modifier"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("fabulousfletching:textures/screens/fletching_gui_template.png"), this.leftPos + 0, this.topPos + -1, 0, 0, 176, 166, 176, 166);

		if (RecipePage1DisplayProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("fabulousfletching:textures/screens/recipe_book_p1.png"), this.leftPos + -121, this.topPos + -31, 0, 0, 120, 230, 120, 230);
		}
		if (DisplayFlintArrowRecipeProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("fabulousfletching:textures/screens/flint_arrow_recipe.png"), this.leftPos + -121, this.topPos + -31, 0, 0, 120, 230, 120, 230);
		}
		if (DisplayForgedArrowRecipeProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("fabulousfletching:textures/screens/forged_arrow_recipe.png"), this.leftPos + -121, this.topPos + -31, 0, 0, 120, 230, 120, 230);
		}
		if (DisplayGoldArrowRecipeProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("fabulousfletching:textures/screens/gold_arrow_recipe.png"), this.leftPos + -121, this.topPos + -31, 0, 0, 120, 230, 120, 230);
		}
		if (DisplayIronArrowRecipeProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("fabulousfletching:textures/screens/iron_arrow_recipe.png"), this.leftPos + -121, this.topPos + -31, 0, 0, 120, 230, 120, 230);
		}
		if (DisplayJeweledArrowRecipeProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("fabulousfletching:textures/screens/jeweled_arrow_recipe.png"), this.leftPos + -121, this.topPos + -31, 0, 0, 120, 230, 120, 230);
		}
		if (DisplayTippedArrowRecipeProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("fabulousfletching:textures/screens/tipped_arrow_recipe.png"), this.leftPos + -121, this.topPos + -31, 0, 0, 120, 230, 120, 230);
		}
		if (RecipePage2DisplayProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("fabulousfletching:textures/screens/recipe_book_p2.png"), this.leftPos + -121, this.topPos + -31, 0, 0, 120, 230, 120, 230);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.fabulousfletching.fletching_gui.label_fletch_and_tip"), 52, 14, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_guirecipebookoff = new ImageButton(this.leftPos + 16, this.topPos + 52, 20, 18,
				new WidgetSprites(ResourceLocation.parse("fabulousfletching:textures/screens/guirecipebookoff.png"), ResourceLocation.parse("fabulousfletching:textures/screens/guirecipebookon.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FletchingGuiButtonMessage(0, x, y, z));
						FletchingGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_guirecipebookoff", imagebutton_guirecipebookoff);
		this.addRenderableWidget(imagebutton_guirecipebookoff);
		imagebutton_arrowrightup = new ImageButton(this.leftPos + -47, this.topPos + 138, 11, 17,
				new WidgetSprites(ResourceLocation.parse("fabulousfletching:textures/screens/arrowrightunpressed.png"), ResourceLocation.parse("fabulousfletching:textures/screens/arrowrightpressed.png")), e -> {
					if (RecipeBookOpenProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new FletchingGuiButtonMessage(1, x, y, z));
						FletchingGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (RecipeBookOpenProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_arrowrightup", imagebutton_arrowrightup);
		this.addRenderableWidget(imagebutton_arrowrightup);
		imagebutton_arrowleftup = new ImageButton(this.leftPos + -87, this.topPos + 138, 11, 17,
				new WidgetSprites(ResourceLocation.parse("fabulousfletching:textures/screens/arrowleftunpressed.png"), ResourceLocation.parse("fabulousfletching:textures/screens/arrowleftpressed.png")), e -> {
					if (RecipeBookOpenProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new FletchingGuiButtonMessage(2, x, y, z));
						FletchingGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (RecipeBookOpenProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_arrowleftup", imagebutton_arrowleftup);
		this.addRenderableWidget(imagebutton_arrowleftup);
	}
}
