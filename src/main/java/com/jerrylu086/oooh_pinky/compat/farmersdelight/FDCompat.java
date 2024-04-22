package com.jerrylu086.oooh_pinky.compat.farmersdelight;

import com.jerrylu086.oooh_pinky.items.tiers.ModItemTier;
import com.jerrylu086.oooh_pinky.registry.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.KnifeItem;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

public class FDCompat {
    public static final RegistryObject<KnifeItem> ROSE_GOLD_KNIFE = ModItems.ITEMS.register(
            "rose_gold_knife", () -> new KnifeItem(ModItemTier.ROSE_GOLD, 0.5F, -1.5F,
                    new Item.Properties()));

    public static void addToFDTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey())
            event.getEntries().putAfter(
                    new ItemStack(vectorwing.farmersdelight.common.registry.ModItems.GOLDEN_KNIFE.get()),
                    new ItemStack(ROSE_GOLD_KNIFE.get()),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    public static void init() {}
}
