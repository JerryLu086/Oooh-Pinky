package com.jerrylu086.oooh_pinky.registry;

import com.jerrylu086.oooh_pinky.OoohPinky;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OoohPinky.MOD_ID);

    public static final RegistryObject<Block> ROSE_GOLD_BLOCK = BLOCKS.register("rose_gold_block",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_PINK)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(2)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.METAL)));
}
