package tfar.unifiedstamina.compat.paraglider;

import net.minecraft.resources.ResourceLocation;
import tfar.unifiedstamina.USPlayerDuck;
import tfar.unifiedstamina.UnifiedStamina;
import tictim.paraglider.api.movement.MovementPlugin;
import tictim.paraglider.api.movement.ParagliderPlayerStates;
import tictim.paraglider.api.plugin.ParagliderPlugin;

@ParagliderPlugin
public class CombatRollPlugin implements MovementPlugin {

    public static final ResourceLocation ROLL = UnifiedStamina.id("roll");

    @Override
    public void registerNewStates(PlayerStateRegister register) {
        register.register(ROLL, -20);
    }

    @Override
    public void registerStateConnections(PlayerStateConnectionRegister register) {
        register.addBranch(ParagliderPlayerStates.IDLE,(player, playerState, b, v) -> {
            return ((USPlayerDuck)player).isRolling();
        },ROLL);
    }
}
