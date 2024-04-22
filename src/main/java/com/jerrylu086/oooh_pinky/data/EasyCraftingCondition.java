package com.jerrylu086.oooh_pinky.data;

import com.google.gson.JsonObject;
import com.jerrylu086.oooh_pinky.core.Configuration;
import com.jerrylu086.oooh_pinky.OoohPinky;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class EasyCraftingCondition implements ICondition {
    private static final ResourceLocation NAME = new ResourceLocation(OoohPinky.MOD_ID, "easy_crafting");

    @Override
    public ResourceLocation getID() {
        return NAME;
    }

    @Override
    public boolean test() {
        return Configuration.EASY_CRAFTING.get();
    }

    public static class Serializer implements IConditionSerializer<EasyCraftingCondition> {
        @Override
        public void write(JsonObject json, EasyCraftingCondition value) {
            // Hello there
        }

        @Override
        public EasyCraftingCondition read(JsonObject json) {
            return new EasyCraftingCondition();
        }

        @Override
        public ResourceLocation getID() {
            return EasyCraftingCondition.NAME;
        }
    }
}