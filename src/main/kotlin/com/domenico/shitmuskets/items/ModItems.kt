package com.domenico.shitmuskets.items

import com.domenico.shitmuskets.Shitmuskets
import com.domenico.shitmuskets.items.customs.Musket
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.Item

object ModItems {
    fun <T: Item> register(name: String, factory: (Item.Properties) -> T, settings: Item.Properties): T {
        val itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Shitmuskets.MOD_ID, name))
        val item: T = factory(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    val MUSKET = register("musket", ::Musket, Item.Properties())

    fun initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register { ctx ->
            ctx.accept(MUSKET);
        }
    }
}