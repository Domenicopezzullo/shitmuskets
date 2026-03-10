package com.domenico.shitmuskets.items

import com.domenico.shitmuskets.Shitmuskets
import com.mojang.serialization.Codec
import net.minecraft.core.Registry
import net.minecraft.core.component.DataComponentType
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier

object ModDataComponents {
    val LOADED = Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, Identifier.fromNamespaceAndPath(Shitmuskets.MOD_ID, "loaded"),
        DataComponentType.builder<Boolean>().persistent(Codec.BOOL).build());

    fun initialize() {
    }
}
