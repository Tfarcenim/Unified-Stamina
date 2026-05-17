package tfar.unifiedstamina.compat.paraglider;

import net.minecraft.resources.ResourceLocation;
import tfar.unifiedstamina.ModIntegration;
import tfar.unifiedstamina.USPlayerDuck;
import tfar.unifiedstamina.UnifiedStamina;
import tfar.unifiedstamina.compat.swordblockingmechanics.StaminaCompat;
import tictim.paraglider.api.movement.MovementPlugin;
import tictim.paraglider.api.movement.ParagliderPlayerStates;
import tictim.paraglider.api.plugin.ParagliderPlugin;

@ParagliderPlugin
public class CombatRollPlugin implements MovementPlugin {

    public static final ResourceLocation ROLL = UnifiedStamina.id("roll");
    public static final ResourceLocation PARRY = UnifiedStamina.id("parry");

    @Override
    public void registerNewStates(PlayerStateRegister register) {
        register.register(ROLL, -20);
        register.register(PARRY, -10);
    }

    @Override
    public void registerStateConnections(PlayerStateConnectionRegister register) {
        register.addBranch(ParagliderPlayerStates.IDLE,(player, playerState, b, v) -> {
            return ((USPlayerDuck)player).isRolling();
        },ROLL);

        if (ModIntegration.swordblockingmechanics.loaded) {
            StaminaCompat.setup(register);
        }
    }
}
