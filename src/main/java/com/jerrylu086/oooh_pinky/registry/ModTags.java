package com.jerrylu086.oooh_pinky.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    // Item
    public static final TagKey<Item> ROSE_GOLD_INGOT =
            TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "ingots/rose_gold"));
}
