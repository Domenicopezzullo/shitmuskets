package com.domenico.shitmuskets.items

import com.domenico.shitmuskets.Shitmuskets
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.Item

object ModItems {
    fun <T: Item> register(name: String, factory: (Item.Properties) -> T, settings: Item.Properties): T {
        val itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Shitmuskets.MOD_ID, name))
        val item: T = factory(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    fun initialize() {}
}