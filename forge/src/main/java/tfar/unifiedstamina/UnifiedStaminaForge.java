package tfar.unifiedstamina;

import net.minecraftforge.fml.common.Mod;

@Mod(UnifiedStamina.MOD_ID)
public class UnifiedStaminaForge {
    
    public UnifiedStaminaForge() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        UnifiedStamina.init();
        
    }
}