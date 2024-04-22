package com.jerrylu086.oooh_pinky.items;

import com.jerrylu086.oooh_pinky.core.Configuration;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SimpleBarterItem extends Item {
    public SimpleBarterItem(Properties properties) {
        super(properties);
    }

    // Ahhhhh Forge why did you do this
    @Override
    public boolean isPiglinCurrency(ItemStack stack) {
        return Configuration.ROSE_GOLD_BARTERING.get();
    }
}
