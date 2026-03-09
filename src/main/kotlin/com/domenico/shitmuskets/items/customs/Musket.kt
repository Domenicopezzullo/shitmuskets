package com.domenico.shitmuskets.items.customs

import com.mojang.serialization.Codec
import net.minecraft.core.component.DataComponentType
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.level.Level

class Musket(properties: Item.Properties) : Item(properties) {
    companion object {
        val LOADED = DataComponentType.builder<Boolean>().persistent(Codec.BOOL).build();
    }

    override fun use(level: Level, player: Player, interactionHand: InteractionHand): InteractionResult {



        return InteractionResult.SUCCESS;
    }
}