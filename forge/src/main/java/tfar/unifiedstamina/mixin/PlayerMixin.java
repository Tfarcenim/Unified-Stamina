package tfar.unifiedstamina.mixin;

import net.combatroll.internals.RollManager;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import tfar.unifiedstamina.USPlayerDuck;

@Mixin(Player.class)
public class PlayerMixin implements USPlayerDuck {

    int rollTimer;
    int superParryTimer;
    boolean superParrySuccessful;

    @Override
    public void markAsRolling() {
        rollTimer = RollManager.rollDuration();
    }

    @Override
    public boolean isRolling() {
        return rollTimer > 0;
    }

    @Override
    public void update() {
        if (rollTimer > 0) {rollTimer--;}
        if (superParryTimer > 0) {superParryTimer--;}
    }

    @Override
    public boolean isSuperParrying() {
        return superParryTimer>0;
    }

    @Override
    public boolean superParrySuccessful() {
        return superParrySuccessful;
    }

    @Override
    public void markSuperParrySuccessful(boolean superParrySuccessful) {
        this.superParrySuccessful = superParrySuccessful;
    }

    @Override
    public void markSuperParrying() {
        superParryTimer = 5;
    }
}
