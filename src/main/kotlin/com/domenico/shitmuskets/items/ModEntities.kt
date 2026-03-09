package com.domenico.shitmuskets.items

import com.domenico.shitmuskets.Shitmuskets
import com.domenico.shitmuskets.items.customs.Projectile
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory

object ModEntities {
    val BULLET: EntityType<Projectile> by lazy {
        Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Shitmuskets.MOD_ID, "bullet"),
            EntityType.Builder.of(::Projectile, MobCategory.MISC)
                .sized(0.25f, 0.25f)
                .build(
                    ResourceKey.create(
                    Registries.ENTITY_TYPE,
                    Identifier.fromNamespaceAndPath(Shitmuskets.MOD_ID, "bullet")
                ))
        )
    }

    fun initialize() {
        BULLET
    }
}