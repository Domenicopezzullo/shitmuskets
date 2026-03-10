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
    @Inject(remap = false, method = "renderCrosshair", at = @At("HEAD"), cancellable = true)
    void cancelCrosshair(GuiGraphics graphics, DeltaTracker dt, CallbackInfo info) {
        Player player = Minecraft.getInstance().player;
        assert player != null;
        if (player.getMainHandItem().getItem() instanceof Musket) {
            info.cancel();
        } else return;
        int screenWidth = Minecraft.getInstance().getWindow().getGuiScaledWidth();
        int screenHeight = Minecraft.getInstance().getWindow().getGuiScaledHeight();
        int cx = screenWidth / 2;
        int cy = screenHeight / 2;

        int len = 6;
        int gap = 3;
        int color = 0xFFFFFFFF;
        graphics.fill(cx - len - 1, cy - 1, cx - gap - 1, cy, color);
        graphics.fill(cx + gap - 1, cy - 1, cx + len - 1, cy, color);

        graphics.fill(cx - 1, cy - len, cx, cy - gap, color);
        graphics.fill(cx - 1, cy + gap, cx, cy + len, color);
    }
}
