package com.jerrylu086.oooh_pinky.compat.farmersdelight;

import com.jerrylu086.oooh_pinky.items.tiers.ModItemTier;
import com.jerrylu086.oooh_pinky.registry.ModItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class FDCompat {
    public static final RegistryObject<KnifeItem> ROSE_GOLD_KNIFE = ModItems.ITEMS.register(
            "rose_gold_knife", () -> new KnifeItem(ModItemTier.ROSE_GOLD, 0.5F, -1.5F,
                    new Item.Properties().tab(FarmersDelight.CREATIVE_TAB)));

    public static void init() {}
}
