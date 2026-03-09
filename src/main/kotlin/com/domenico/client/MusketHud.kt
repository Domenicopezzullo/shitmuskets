package com.domenico.client

import com.domenico.shitmuskets.items.ModDataComponents
import com.domenico.shitmuskets.items.customs.Musket
import com.mojang.authlib.minecraft.client.MinecraftClient
import net.minecraft.client.DeltaTracker
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics


class MusketHud {
    fun render(graphics: GuiGraphics, tickCounter: DeltaTracker) {
        val client = Minecraft.getInstance();
        val player = client.player ?: return;
        val item = player.mainHandItem;

        if(item.item !is Musket) return;

        val loaded = item.getOrDefault(ModDataComponents.LOADED, false);
        val onCooldown = client.player!!.cooldowns.isOnCooldown(item);
        if(onCooldown) return;
        val screenWidth = client.window.guiScaledWidth;
        val screenHeight = client.window.guiScaledHeight;

        val text = if(loaded) "●" else "○"
        val color = if(loaded) 0xFF00FF00.toInt() else 0xFFFF4444.toInt()

        val x = screenWidth / 2 - client.font.width(text) / 2
        val y = screenHeight - 60

        graphics.drawString(client.font, text, x, y, color)
    }
}