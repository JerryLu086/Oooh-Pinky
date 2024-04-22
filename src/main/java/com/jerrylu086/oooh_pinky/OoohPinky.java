package com.jerrylu086.oooh_pinky;

import com.jerrylu086.oooh_pinky.core.Configuration;
import com.jerrylu086.oooh_pinky.registry.ModBlocks;
import com.jerrylu086.oooh_pinky.registry.ModCodecs;
import com.jerrylu086.oooh_pinky.registry.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(OoohPinky.MOD_ID)
public class OoohPinky {
    public static final String MOD_ID = "oooh_pinky";
    public static final Logger LOGGER = LogManager.getLogger("Oooh, Pinky!");

    public static final String LEGACY_ID = "rosegold"; // Not used anymore after 1.18, was only for remapping purpose, but I'll keep it

    public OoohPinky(IEventBus modEventBus) {
        Configuration.init();

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModCodecs.CODECS.register(modEventBus);

        modEventBus.addListener(ModItems::addToTabs);
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
