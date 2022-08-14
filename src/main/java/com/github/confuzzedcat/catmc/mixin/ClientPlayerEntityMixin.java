package com.github.confuzzedcat.catmc.mixin;
import com.github.confuzzedcat.catmc.client.CatmcClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Inject(at = @At("TAIL"), method = "tick")
    public void tick(CallbackInfo ci) {
        CatmcClient.tick();
    }
}
