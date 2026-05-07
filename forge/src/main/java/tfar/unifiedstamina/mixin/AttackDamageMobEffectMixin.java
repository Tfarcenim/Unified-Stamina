package tfar.unifiedstamina.mixin;

import net.minecraft.world.effect.AttackDamageMobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.unifiedstamina.UnifiedStamina;

@Mixin(AttackDamageMobEffect.class)
public class AttackDamageMobEffectMixin {

    @Inject(method = "getAttributeModifierValue",at = @At("HEAD"),cancellable = true)
    private void unhardcodeAttribute(int amplifier, AttributeModifier modifier, CallbackInfoReturnable<Double> cir) {
        if (modifier.getId().equals(UnifiedStamina.STRENGTH_UUID)) {
            cir.setReturnValue(modifier.getAmount() * (double)(amplifier + 1));
        }
    }
}
