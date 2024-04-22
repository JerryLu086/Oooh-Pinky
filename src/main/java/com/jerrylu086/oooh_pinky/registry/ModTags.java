package com.jerrylu086.oooh_pinky.registry;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ModTags {
    // Item
    public static final Tags.IOptionalNamedTag<Item> ROSE_GOLD_INGOT =
            ItemTags.createOptional(new ResourceLocation("forge", "ingots/rose_gold"));
}
