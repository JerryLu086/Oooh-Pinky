package com.jerrylu086.oooh_pinky.compat.farmersdelight;

import com.jerrylu086.oooh_pinky.items.tiers.ModItemTier;
import com.jerrylu086.oooh_pinky.registry.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.items.KnifeItem;

public class FDCompat {
    public static final RegistryObject<KnifeItem> ROSE_GOLD_KNIFE = ModItems.ITEMS.register(
            "rose_gold_knife", () -> new KnifeItem(ModItemTier.ROSE_GOLD, 0.5F, -1.5F,
                    new Item.Properties().tab(FarmersDelight.ITEM_GROUP)));

    public static void init() {}
}
