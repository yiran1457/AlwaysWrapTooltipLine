package com.yiran.awtl.mixin;

import net.minecraftforge.client.ForgeHooksClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = ForgeHooksClient.class,remap = false)
public class ForgeHooksClientMixin {
    @ModifyVariable(
            method = "gatherTooltipComponentsFromElements",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraftforge/client/event/RenderTooltipEvent$GatherComponents;getMaxWidth()I",
                    ordinal = 0
            ),
            name = "needsWrap")
    private static boolean alwaysWrap(boolean needsWrap){
        return true;
    }
}
