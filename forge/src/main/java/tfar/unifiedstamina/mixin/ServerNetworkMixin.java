package tfar.unifiedstamina.mixin;

import net.combatroll.fabricmc.fabric.api.networking.v1.PacketSender;
import net.combatroll.network.ServerNetwork;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tfar.unifiedstamina.UnifiedStamina;

@Mixin(ServerNetwork.class)
@Debug(export = true)
public class ServerNetworkMixin {
    /*@Inject(method = "lambda$initializeHandlers$5",at = @At(value = "RETURN",ordinal = 1))
    private static void onPacketReceived(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler,
                                         FriendlyByteBuf buf, PacketSender responseSender, CallbackInfo ci) {
        UnifiedStamina.onRollPublish(handler,player,server);
    }*/
}
