package com.jerrylu086.oooh_pinky.data;

import com.jerrylu086.oooh_pinky.core.Configuration;
import com.mojang.serialization.Codec;
import net.neoforged.neoforge.common.conditions.ICondition;

public class EasyCraftingCondition implements ICondition {
    public static final Codec<EasyCraftingCondition> CODEC = Codec.unit(new EasyCraftingCondition());

    @Override
    public boolean test(IContext context) {
        return Configuration.EASY_CRAFTING.get();
    }

    @Override
    public Codec<? extends ICondition> codec() {
        return CODEC;
    }
}