package com.jerrylu086.oooh_pinky.core;

import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Configuration {
    public static ModConfigSpec COMMON;
    public static ModConfigSpec.BooleanValue EASY_CRAFTING;
    public static ModConfigSpec.BooleanValue ROSE_GOLD_BARTERING;

    public static void init() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        EASY_CRAFTING =
                builder.comment("If you have other mods loaded, you might want to make rose gold not that easy to get (for example, Create).")
                .define("easyCrafting", true);
        ROSE_GOLD_BARTERING =
                builder.comment("By default, you can use Rose Gold Ingots to barter with Piglins.")
                .define("roseGoldBartering", true);
        COMMON = builder.build();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON);
    }
}
