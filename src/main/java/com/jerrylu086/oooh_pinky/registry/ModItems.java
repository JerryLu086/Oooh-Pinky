package com.jerrylu086.oooh_pinky.registry;

import com.jerrylu086.oooh_pinky.OoohPinky;
import com.jerrylu086.oooh_pinky.compat.farmersdelight.FDCompat;
import com.jerrylu086.oooh_pinky.items.PiglinNeutralArmor;
import com.jerrylu086.oooh_pinky.items.SimpleBarterItem;
import com.jerrylu086.oooh_pinky.items.tiers.ModArmorMaterial;
import com.jerrylu086.oooh_pinky.items.tiers.ModItemTier;

import net.minecraft.world.item.*;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OoohPinky.MOD_ID);

    // Blocks
    public static final RegistryObject<BlockItem> ROSE_GOLD_BLOCK = ITEMS.register("rose_gold_block",
            () -> new BlockItem(ModBlocks.ROSE_GOLD_BLOCK.get(), new Item.Properties()));

    // Essentials
    public static final RegistryObject<Item> ROSE_GOLD_INGOT = ITEMS.register("rose_gold_ingot",
            () -> new SimpleBarterItem(new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_NUGGET = ITEMS.register("rose_gold_nugget",
            () -> new Item(new Item.Properties()));

    // Tools & armor
    public static final RegistryObject<SwordItem> ROSE_GOLD_SWORD = ITEMS.register("rose_gold_sword",
            () -> new SwordItem(ModItemTier.ROSE_GOLD, 3, -2.2F,
                    new Item.Properties()));
    public static final RegistryObject<ShovelItem> ROSE_GOLD_SHOVEL = ITEMS.register("rose_gold_shovel",
            () -> new ShovelItem(ModItemTier.ROSE_GOLD, 1.5F, -3.0F,
                    new Item.Properties()));
    public static final RegistryObject<PickaxeItem> ROSE_GOLD_PICKAXE = ITEMS.register("rose_gold_pickaxe",
            () -> new PickaxeItem(ModItemTier.ROSE_GOLD, 1, -2.8F,
                    new Item.Properties()));
    public static final RegistryObject<AxeItem> ROSE_GOLD_AXE = ITEMS.register("rose_gold_axe",
            () -> new AxeItem(ModItemTier.ROSE_GOLD, 6.0F, -3.1F,
                    new Item.Properties()));
    public static final RegistryObject<HoeItem> ROSE_GOLD_HOE = ITEMS.register("rose_gold_hoe",
            () -> new HoeItem(ModItemTier.ROSE_GOLD,-2, -1,
                    new Item.Properties()));

    public static final RegistryObject<Item> ROSE_GOLD_HELMET = ITEMS.register("rose_gold_helmet",
            () -> new PiglinNeutralArmor(ModArmorMaterial.ROSE_GOLD, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_CHESTPLATE = ITEMS.register("rose_gold_chestplate",
            () -> new PiglinNeutralArmor(ModArmorMaterial.ROSE_GOLD, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_LEGGINGS = ITEMS.register("rose_gold_leggings",
            () -> new PiglinNeutralArmor(ModArmorMaterial.ROSE_GOLD, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_BOOTS = ITEMS.register("rose_gold_boots",
            () -> new PiglinNeutralArmor(ModArmorMaterial.ROSE_GOLD, ArmorItem.Type.BOOTS,
                    new Item.Properties()));

    public static void addToTabs(BuildCreativeModeTabContentsEvent event) {
        // Man this is soo freaking long
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.getEntries().putAfter(new ItemStack(Items.GOLD_BLOCK), new ItemStack(ROSE_GOLD_BLOCK.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.getEntries().putAfter(new ItemStack(Items.GOLDEN_HOE), new ItemStack(ROSE_GOLD_HOE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.GOLDEN_HOE), new ItemStack(ROSE_GOLD_AXE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.GOLDEN_HOE), new ItemStack(ROSE_GOLD_SHOVEL.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.GOLDEN_HOE), new ItemStack(ROSE_GOLD_PICKAXE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.getEntries().putAfter(new ItemStack(Items.GOLDEN_SWORD), new ItemStack(ROSE_GOLD_SWORD.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.GOLDEN_BOOTS), new ItemStack(ROSE_GOLD_BOOTS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.GOLDEN_BOOTS), new ItemStack(ROSE_GOLD_LEGGINGS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.GOLDEN_BOOTS), new ItemStack(ROSE_GOLD_CHESTPLATE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.GOLDEN_BOOTS), new ItemStack(ROSE_GOLD_HELMET.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.getEntries().putAfter(new ItemStack(Items.GOLD_NUGGET), new ItemStack(ROSE_GOLD_NUGGET.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.GOLD_INGOT), new ItemStack(ROSE_GOLD_INGOT.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (ModList.get().isLoaded("farmersdelight"))
            FDCompat.addToFDTab(event);
    }
}
