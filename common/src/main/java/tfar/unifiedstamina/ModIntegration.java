package tfar.unifiedstamina;

import tfar.unifiedstamina.platform.Services;

public enum ModIntegration {
    swordblockingmechanics;

    ModIntegration() {
        loaded = Services.PLATFORM.isModLoaded(name());
    }
    public final boolean loaded;

}
