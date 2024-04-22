package com.jerrylu086.oooh_pinky.registry;

import com.jerrylu086.oooh_pinky.OoohPinky;
import com.jerrylu086.oooh_pinky.data.EasyCraftingCondition;
import com.mojang.serialization.Codec;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModCodecs {
    public static final DeferredRegister<Codec<? extends ICondition>> CODECS = DeferredRegister.create(NeoForgeRegistries.CONDITION_SERIALIZERS, OoohPinky.MOD_ID);

    public static final Supplier<Codec<? extends ICondition>> EASY_CRAFTING = CODECS.register("easy_crafting", () -> EasyCraftingCondition.CODEC);
}
