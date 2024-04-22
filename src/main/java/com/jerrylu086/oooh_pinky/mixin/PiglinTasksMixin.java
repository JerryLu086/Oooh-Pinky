package com.jerrylu086.oooh_pinky.mixin;

import com.jerrylu086.oooh_pinky.OoohPinky;
import com.jerrylu086.oooh_pinky.core.Configuration;
import com.jerrylu086.oooh_pinky.registry.ModTags;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

// Taking reference from: Custom Piglin Bartering
// https://gitlab.com/supersaiyansubtlety/custom_piglin_bartering/-/blob/master/src/main/java/net/sssubtlety/custom_piglin_bartering/mixin/PiglinBrainMixin.java

@Mixin(PiglinTasks.class)
public abstract class PiglinTasksMixin {
    @Unique
    private static final ResourceLocation ROSE_GOLD_BARTERING_PATH = new ResourceLocation(OoohPinky.MOD_ID, "gameplay/rose_gold_bartering");
    @Unique
    private static final String SPECIAL_BARTER_DATA_KEY = OoohPinky.MOD_ID + ":special_barter";

    // Guess Forge does not use this? I'll just keep it here anyways.
    @Inject(method = "isBarterCurrency", at = @At("HEAD"), cancellable = true)
    private static void isBarterCurrency(Item item, CallbackInfoReturnable<Boolean> cir) {
        if (item.is(ModTags.ROSE_GOLD_INGOT))
            cir.setReturnValue(Configuration.ROSE_GOLD_BARTERING.get());
    }

    @Inject(method = "stopHoldingOffHandItem", at = @At("HEAD"))
    private static void clearBarterItem(PiglinEntity piglin, boolean doBarter, CallbackInfo ci) {
        piglin.getPersistentData().remove(SPECIAL_BARTER_DATA_KEY);
    }

    @Inject(method = "stopHoldingOffHandItem",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/monster/piglin/PiglinTasks;getBarterResponseItems(Lnet/minecraft/entity/monster/piglin/PiglinEntity;)Ljava/util/List;"),
            locals = LocalCapture.CAPTURE_FAILHARD)
    private static void setBarterItem(PiglinEntity piglin, boolean doBarter, CallbackInfo ci, ItemStack held, boolean accepted) {
        // Well, I'll leave this here, since Forge requires overriding a method to add new barter items,
        // and...guess none of the existing mods with rose gold does that.
        if (held.getItem().is(ModTags.ROSE_GOLD_INGOT))
            piglin.getPersistentData().putBoolean(SPECIAL_BARTER_DATA_KEY, true);
    }

    @Inject(method = "getBarterResponseItems", at = @At(value = "RETURN"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private static void getBarterResponseItems(PiglinEntity piglin, CallbackInfoReturnable<List<ItemStack>> cir, LootTable loots) {
        // This looks so weird
        if (piglin.getPersistentData().getBoolean(SPECIAL_BARTER_DATA_KEY))
            cir.setReturnValue(piglin.level.getServer().getLootTables().get(ROSE_GOLD_BARTERING_PATH)
                    .getRandomItems((new LootContext.Builder((ServerWorld) piglin.level))
                            .withParameter(LootParameters.THIS_ENTITY, piglin)
                            .withRandom(piglin.level.random)
                            .create(LootParameterSets.PIGLIN_BARTER)));
    }
}
