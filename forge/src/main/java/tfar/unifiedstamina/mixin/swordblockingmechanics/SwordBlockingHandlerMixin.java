package tfar.unifiedstamina.mixin.swordblockingmechanics;

import fuzs.puzzleslib.api.event.v1.core.EventResult;
import fuzs.swordblockingmechanics.SwordBlockingMechanics;
import fuzs.swordblockingmechanics.config.ServerConfig;
import fuzs.swordblockingmechanics.handler.SwordBlockingHandler;
import fuzs.swordblockingmechanics.init.ModRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import static fuzs.swordblockingmechanics.handler.SwordBlockingHandler.getParryStrengthScale;
import static fuzs.swordblockingmechanics.handler.SwordBlockingHandler.isActiveItemStackBlocking;

@Mixin(SwordBlockingHandler.class)
public class SwordBlockingHandlerMixin {

    @Shadow(remap = false)
    private static boolean canBlockDamageSource(Player player, DamageSource source) {
        throw new UnsupportedOperationException("Implemented via mixin");
    }

    @Shadow(remap = false)
    private static void hurtSwordInUse(Player player, float damageAmount) {
        throw new UnsupportedOperationException("Implemented via mixin");
    }

    /**
     * @author
     * @reason
     *
    @Overwrite
    public static EventResult onLivingAttack(LivingEntity entity, DamageSource damageSource, float damageAmount) {
        if (!entity.level().isClientSide && entity instanceof Player player) {
            if (isActiveItemStackBlocking(player)) {
                if (damageAmount > 0.0F && canBlockDamageSource(player, damageSource)) {
                    boolean parryIsActive = getParryStrengthScale(player) > (double)0.0F;
                    if (parryIsActive || SwordBlockingMechanics.CONFIG.get(ServerConfig.class).deflectProjectiles && damageSource.is(DamageTypeTags.IS_PROJECTILE)) {
                        if (parryIsActive && SwordBlockingMechanics.CONFIG.get(ServerConfig.class).damageSwordOnParry || !parryIsActive && SwordBlockingMechanics.CONFIG.get(ServerConfig.class).damageSword) {
                            hurtSwordInUse(player, damageAmount);
                        }

                        if (parryIsActive && !damageSource.is(DamageTypeTags.IS_PROJECTILE)) {
                            Entity var6 = damageSource.getDirectEntity();
                            if (var6 instanceof LivingEntity directEntity) {
                                directEntity.knockback(SwordBlockingMechanics.CONFIG.get(ServerConfig.class).parryKnockbackStrength, player.getX() - directEntity.getX(), player.getZ() - directEntity.getZ());
                            }
                        }

                        player.level().playSound(null, player.getX(), player.getY(), player.getZ(), ModRegistry.ITEM_SWORD_BLOCK_SOUND_EVENT.get(), player.getSoundSource(), 1.0F, 0.8F + player.level().getRandom().nextFloat() * 0.4F);
                        return EventResult.INTERRUPT;
                    }
                }

                return EventResult.PASS;
            }
        }

        return EventResult.PASS;
    }*/

}
