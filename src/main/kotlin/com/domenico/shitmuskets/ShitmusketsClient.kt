package com.domenico.shitmuskets

import com.domenico.shitmuskets.items.ModEntities
import com.domenico.shitmuskets.items.customs.Projectile
import net.fabricmc.api.ClientModInitializer
import net.minecraft.client.renderer.entity.ArrowRenderer
import net.minecraft.client.renderer.entity.EntityRenderers
import net.minecraft.client.renderer.entity.state.ArrowRenderState
import net.minecraft.resources.Identifier

class ShitmusketsClient : ClientModInitializer {
    override fun onInitializeClient() {
        EntityRenderers.register(ModEntities.BULLET) {ctx ->
          object: ArrowRenderer<Projectile, ArrowRenderState>(ctx) {
              override fun getTextureLocation(arrowRenderState: ArrowRenderState): Identifier = Identifier.fromNamespaceAndPath(Shitmuskets.MOD_ID, "textures/entity/projectile.png")
              override fun createRenderState(): ArrowRenderState = ArrowRenderState()
          }
        }
    }
}