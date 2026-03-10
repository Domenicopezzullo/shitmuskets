package com.domenico.client

import com.domenico.shitmuskets.Shitmuskets
import com.domenico.shitmuskets.items.ModEntities
import com.domenico.shitmuskets.items.customs.Projectile
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements
import net.minecraft.client.renderer.entity.ArrowRenderer
import net.minecraft.client.renderer.entity.EntityRenderers
import net.minecraft.client.renderer.entity.state.ArrowRenderState
import net.minecraft.resources.Identifier

class ShitmusketsClient : ClientModInitializer {
    override fun onInitializeClient() {
        HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, Identifier.fromNamespaceAndPath(Shitmuskets.MOD_ID, "musket_hud")) {p0, p1 ->
            MusketHud().render(p0, p1)
        }
        EntityRenderers.register(ModEntities.BULLET) { ctx ->
          object: ArrowRenderer<Projectile, ArrowRenderState>(ctx) {
              override fun getTextureLocation(arrowRenderState: ArrowRenderState): Identifier = Identifier.fromNamespaceAndPath(
                  Shitmuskets.MOD_ID, "textures/entity/cartridge.png")
              override fun createRenderState(): ArrowRenderState = ArrowRenderState()
          }
        }
    }
}
