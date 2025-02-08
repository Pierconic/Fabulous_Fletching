
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fabulousfletching.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.fabulousfletching.client.model.Modelorb_arrow_model;
import net.mcreator.fabulousfletching.client.model.Modelbomb_arrow_model;
import net.mcreator.fabulousfletching.client.model.Modelarrow_model;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class FabulousfletchingModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelbomb_arrow_model.LAYER_LOCATION, Modelbomb_arrow_model::createBodyLayer);
		event.registerLayerDefinition(Modelorb_arrow_model.LAYER_LOCATION, Modelorb_arrow_model::createBodyLayer);
		event.registerLayerDefinition(Modelarrow_model.LAYER_LOCATION, Modelarrow_model::createBodyLayer);
	}
}
