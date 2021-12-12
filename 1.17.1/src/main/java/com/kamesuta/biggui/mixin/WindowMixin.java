package com.kamesuta.biggui.mixin;

import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Window.class)
public class WindowMixin {
    @Inject(method = "calculateScaleFactor", cancellable = true, at = @At(value = "HEAD"))
    public void calculateScaleFactor(int guiScale, boolean forceUnicodeFont, CallbackInfoReturnable<Integer> cir) {
        if (guiScale > 0) {
            cir.cancel();
            cir.setReturnValue(guiScale);
        }
    }
}
