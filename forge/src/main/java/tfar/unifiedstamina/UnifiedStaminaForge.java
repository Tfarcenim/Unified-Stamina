package tfar.unifiedstamina;

import fuzs.swordblockingmechanics.init.ModRegistry;
import net.combatroll.api.event.ServerSideRollEvents;
import net.combatroll.internals.RollManager;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.RegisterEvent;
import tfar.unifiedstamina.datagen.USDatagen;
import tictim.paraglider.api.stamina.Stamina;

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
        ServerSideRollEvents.PLAYER_START_ROLLING.register((serverPlayer, vec3) -> {

            ((USPlayerDuck)serverPlayer).markAsRolling();

            /*Stamina.get(serverPlayer).takeStamina(ROLL_STAMINA,false,false);//(int amount, boolean simulate, boolean ignoreDepletion)
            Movement movement = Movement.get(serverPlayer);
            movement.setRecoveryDelay(15);
            if (movement instanceof ServerPlayerMovement serverPlayerMovement) {
                serverPlayerMovement.markStaminaVesselChanged();
            }*/
        });

        if (FMLEnvironment.dist.isClient()) {
            USClientForge.init(bus);
        }

        MinecraftForge.EVENT_BUS.addListener(this::playerTick);
    }


    public static boolean checkExtraConditions(Player player){
        return Stamina.get(player).stamina() >= RollManager.rollDuration()*30
                && !Stamina.get(player).isDepleted();
    }

    void playerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            ((USPlayerDuck)event.player).update();
        }
    }

    void addAttributes(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER,USAttributes.STRENGTH,1);
    }

    void setup(FMLCommonSetupEvent event) {
        MobEffects.DAMAGE_BOOST.addAttributeModifier(USAttributes.STRENGTH,
                UnifiedStamina.STRENGTH_UUID.toString(),.2, AttributeModifier.Operation.ADDITION);
    }

    void register(RegisterEvent event) {
        event.register(Registries.ATTRIBUTE,UnifiedStamina.id("generic.strength"),() -> USAttributes.STRENGTH);
    }
}