package com.domenico.shitmuskets.mixin;

import com.domenico.shitmuskets.items.customs.Musket;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {Gui.class}, remap = false)
public class CrosshairMixin {
    @Inject(remap = false, method = "renderCrosshair(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/client/DeltaTracker;)V", at = [At("HEAD")])
    void cancelCrosshair(GuiGraphics graphics, DeltaTracker dt, CallbackInfo info) {
        Player player = Minecraft.getInstance().player;
        assert player != null;
        if(player.getMainHandItem().getItem() instanceof Musket) {
            info.cancel();
        }
    }
}
