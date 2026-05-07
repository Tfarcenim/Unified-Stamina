package tfar.unifiedstamina.mixin;

import net.combatroll.api.EntityAttributes_CombatRoll;
import net.combatroll.internals.RollManager;
import net.combatroll.mixin.PlayerEntityAccessor;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import tfar.unifiedstamina.UnifiedStaminaForge;
import tictim.paraglider.api.stamina.Stamina;

@Mixin(RollManager.class)
public abstract class RollManagerMixin {


    @Shadow(remap = false)
    public boolean isEnabled;

    @Shadow(remap = false)
    public abstract boolean isRolling();

    @Shadow(remap = false)
    private int timeSinceLastRoll;

    @Shadow
    protected abstract void updateCooldownLength(LocalPlayer player);

    @Shadow
    private int currentCooldownProgress;

    @Shadow
    private int currentCooldownLength;

    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false)
    public void tick(LocalPlayer localPlayer) {
        //this.maxRolls = (int) EntityAttributes_CombatRoll.getAttributeValue(player, EntityAttributes_CombatRoll.Type.COUNT);
        ++this.timeSinceLastRoll;
        if (/*this.availableRolls < this.maxRolls*/true) {
            ++this.currentCooldownProgress;
            if (this.currentCooldownProgress >= this.currentCooldownLength) {
                //this.rechargeRoll(player);
            }
        }

        /*if (this.availableRolls == this.maxRolls) {
            this.currentCooldownProgress = 0;
        }*/

        /*if (this.availableRolls > this.maxRolls) {
            this.availableRolls = this.maxRolls;
        }*/
    }

    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false)
    public boolean isRollAvailable(Player player) {
        return this.isEnabled && !this.isRolling() && /*this.availableRolls > 0 &&*/
                !((PlayerEntityAccessor)player).invokeIsImmobile_CombatRoll() && player.isEffectiveAi() && player.getAttributeValue(Attributes.MOVEMENT_SPEED) > (double)0.0F &&
                Stamina.get(player).stamina() >= UnifiedStaminaForge.ROLL_STAMINA;//the change
    }

    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false)
    public void onRoll(LocalPlayer player) {
        //--this.availableRolls;
        this.timeSinceLastRoll = 0;
        this.updateCooldownLength(player);
    }
}
