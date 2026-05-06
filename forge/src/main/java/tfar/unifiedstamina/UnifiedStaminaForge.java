package tfar.unifiedstamina;

import dev.shadowsoffire.attributeslib.api.ALObjects;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import tfar.unifiedstamina.datagen.USDatagen;

import java.util.UUID;

@Mod(UnifiedStamina.MOD_ID)
public class UnifiedStaminaForge {
    
    public UnifiedStaminaForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::register);
        bus.addListener(this::setup);
        bus.addListener(this::addAttributes);
        bus.addListener(USDatagen::gather);
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        UnifiedStamina.init();
        
    }

    void addAttributes(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER,USAttributes.STRENGTH,1);
    }

    void setup(FMLCommonSetupEvent event) {
        MobEffects.DAMAGE_BOOST.addAttributeModifier(USAttributes.STRENGTH,
                UnifiedStamina.fromResourceLocation(UnifiedStamina.id("strength_boost")).toString(),.2, AttributeModifier.Operation.ADDITION);
    }

    void register(RegisterEvent event) {
        event.register(Registries.ATTRIBUTE,UnifiedStamina.id("generic.strength"),() -> USAttributes.STRENGTH);
    }
}