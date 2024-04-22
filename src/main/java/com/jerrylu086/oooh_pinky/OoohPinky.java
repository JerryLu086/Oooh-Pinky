package com.jerrylu086.oooh_pinky;

import com.jerrylu086.oooh_pinky.compat.farmersdelight.FDCompat;
import com.jerrylu086.oooh_pinky.core.Configuration;
import com.jerrylu086.oooh_pinky.data.EasyCraftingCondition;
import com.jerrylu086.oooh_pinky.registry.ModBlocks;
import com.jerrylu086.oooh_pinky.registry.ModItems;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(OoohPinky.MOD_ID)
public class OoohPinky {
    public static final String MOD_ID = "oooh_pinky";
    public static final Logger LOGGER = LogManager.getLogger("Oooh, Pinky!");

    public static final String LEGACY_ID = "rosegold";

    public OoohPinky() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        Configuration.init();

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);

        if (ModList.get().isLoaded("farmersdelight"))
            FDCompat.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        CraftingHelper.register(new EasyCraftingCondition.Serializer());
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static ResourceLocation asResourceLegacy(String path) {
        return new ResourceLocation(LEGACY_ID, path);
    }
}
