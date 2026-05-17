package tfar.unifiedstamina.compat.swordblockingmechanics;

import fuzs.swordblockingmechanics.handler.SwordBlockingHandler;
import tfar.unifiedstamina.compat.paraglider.CombatRollPlugin;
import tictim.paraglider.api.movement.MovementPlugin;
import tictim.paraglider.api.movement.ParagliderPlayerStates;

public class StaminaCompat {
    public static void setup(MovementPlugin.PlayerStateConnectionRegister register){
        register.addBranch(ParagliderPlayerStates.IDLE,(player, playerState, b, v) -> {
            return SwordBlockingHandler.getParryStrengthScale(player) >0;
        }, CombatRollPlugin.PARRY);
    }
}
