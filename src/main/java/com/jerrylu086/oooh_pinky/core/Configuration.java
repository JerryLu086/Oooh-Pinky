package com.jerrylu086.oooh_pinky.core;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Configuration {
    public static ForgeConfigSpec COMMON;
    public static ForgeConfigSpec.BooleanValue EASY_CRAFTING;
    public static ForgeConfigSpec.BooleanValue ROSE_GOLD_BARTERING;

    public static void init() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

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
