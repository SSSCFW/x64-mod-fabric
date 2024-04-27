package com.x64.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.x64.EntityJoinWorldCallback;

@Mixin(ServerWorld.class)
public class EntityJoinWorldMixin {
 
    @Inject(at = @At(value = "INVOKE"), method = "spawnEntity", cancellable = true)
    private void spawnEntityMixin(Entity entity, CallbackInfoReturnable<Boolean> info) {
        EntityJoinWorldCallback.EVENT.invoker().interact(entity);
    }
}