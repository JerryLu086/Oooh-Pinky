package com.jerrylu086.oooh_pinky.core;

import com.jerrylu086.oooh_pinky.OoohPinky;
import com.jerrylu086.oooh_pinky.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

import static com.jerrylu086.oooh_pinky.OoohPinky.MOD_ID;
import static com.jerrylu086.oooh_pinky.OoohPinky.LOGGER;
import static com.jerrylu086.oooh_pinky.OoohPinky.LEGACY_ID;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = MOD_ID)
public class RemappingHandler {
    private static final Map<ResourceLocation, ResourceLocation> toRemap = new HashMap<>();

    static {
        toRemap.put(OoohPinky.asResourceLegacy("crushed_rose_gold"), ModItems.ROSE_GOLD_INGOT.getId());
    }

    @SubscribeEvent
    public static void onBlockRemapping(RegistryEvent.MissingMappings<Block> event) {
        for (RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getMappings(LEGACY_ID)) {
            ResourceLocation key = mapping.key;
            ResourceLocation remappedId = OoohPinky.asResource(key.getPath());

            if (toRemap.containsKey(key))
                remappedId = toRemap.get(key);

            Block remapped = ForgeRegistries.BLOCKS.getValue(remappedId);

            if (remapped != null) {
                LOGGER.warn("Remapping block '{}' to '{}'...", key, remappedId);
                mapping.remap(remapped);
            }
        }
    }

    @SubscribeEvent
    public static void onItemRemapping(RegistryEvent.MissingMappings<Item> event) {
        for (RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getMappings(LEGACY_ID)) {
            ResourceLocation key = mapping.key;
            ResourceLocation remappedId = OoohPinky.asResource(key.getPath());

            if (toRemap.containsKey(key))
                remappedId = toRemap.get(key);

            Item remapped = ForgeRegistries.ITEMS.getValue(remappedId);

            if (remapped != null) {
                LOGGER.warn("Remapping item '{}' to '{}'...", key, remappedId);
                mapping.remap(remapped);
            }
        }
    }
}
