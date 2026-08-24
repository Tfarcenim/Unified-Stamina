package tfar.unifiedstamina.mixin;

import net.combatroll.internals.RollManager;
import net.combatroll.mixin.PlayerEntityAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import tfar.unifiedstamina.UnifiedStaminaForge;

@Mixin(RollManager.class)
public abstract class RollManagerMixin {


    @Shadow(remap = false)
    public boolean isEnabled;

    @Shadow(remap = false)
    public abstract boolean isRolling();

    @Shadow(remap = false)
    private int timeSinceLastRoll;

    @Shadow
    private int currentCooldownLength;

    /**
     * @author
     * @reason
     */
    @SuppressWarnings("ConstantConditions")
    @Overwrite(remap = false)
    public boolean isRollAvailable(Player player) {
        return this.isEnabled && !this.isRolling() && /*this.availableRolls > 0 &&*/
                !((PlayerEntityAccessor)player).invokeIsImmobile_CombatRoll() && player.isEffectiveAi() && player.getAttributeValue(Attributes.MOVEMENT_SPEED) > (double)0.0F &&
                UnifiedStaminaForge.checkExtraConditions(player) && this.timeSinceLastRoll >= this.currentCooldownLength;//the change
    }

}
