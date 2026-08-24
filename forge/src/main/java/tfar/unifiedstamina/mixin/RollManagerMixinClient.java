package tfar.unifiedstamina.mixin;

import net.combatroll.internals.RollManager;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(RollManager.class)
public abstract class RollManagerMixinClient {


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
    public void onRoll(LocalPlayer player) {
        //--this.availableRolls;
        this.timeSinceLastRoll = 0;
        this.updateCooldownLength(player);
    }
}
