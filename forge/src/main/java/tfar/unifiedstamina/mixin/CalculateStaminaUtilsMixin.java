package tfar.unifiedstamina.mixin;

import net.cravencraft.betterparagliders.utils.CalculateStaminaUtils;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.unifiedstamina.USAttributes;

@Mixin(CalculateStaminaUtils.class)
public class CalculateStaminaUtilsMixin {
    @Inject(method = "calculateMeleeStaminaCost",at = @At("RETURN"),cancellable = true,remap = false)
    private static void modifyStaminaCost(Player player, int combo, CallbackInfoReturnable<Integer> cir) {
        if (player.getAttributeValue(USAttributes.STRENGTH) != 1) {
            cir.setReturnValue((int) (cir.getReturnValue() / player.getAttributeValue(USAttributes.STRENGTH)));
        }
    }
}
