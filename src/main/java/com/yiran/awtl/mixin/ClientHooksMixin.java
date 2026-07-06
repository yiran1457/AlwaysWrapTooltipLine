package com.yiran.awtl.mixin;

import net.neoforged.neoforge.client.ClientHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ClientHooks.class)
public class ClientHooksMixin {
    @ModifyVariable(
            method = "gatherTooltipComponentsFromElements",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/neoforged/neoforge/client/event/RenderTooltipEvent$GatherComponents;getMaxWidth()I",
                    ordinal = 0
            ),
            name = "needsWrap")
    private static boolean alwaysWrap(boolean needsWrap){
        return true;
    }

}
