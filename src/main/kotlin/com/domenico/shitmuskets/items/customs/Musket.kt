package com.domenico.shitmuskets.items.customs

import com.domenico.shitmuskets.items.ModDataComponents
import com.domenico.shitmuskets.items.ModItems
import net.minecraft.client.telemetry.TelemetryProperty
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.GameType
import net.minecraft.world.level.Level

class Musket(properties: Item.Properties) : Item(properties) {
    companion object{
        const val COOLDOWN_TIME = 80
    }

    override fun use(level: Level, player: Player, interactionHand: InteractionHand): InteractionResult {
        val item = player.getItemInHand(interactionHand)
        val loaded = item.getOrDefault(ModDataComponents.LOADED, false)

        if (player.cooldowns.isOnCooldown(item)) {
            return InteractionResult.FAIL
        }

        if (loaded) {
            shoot(level, player, item)
        } else {
            reload(level, player, item)
        }

        return InteractionResult.SUCCESS
    }

    private fun reload(level: Level, player: Player, itemStack: ItemStack) {
        if(level.isClientSide) return;
        if(player.gameMode() == GameType.CREATIVE) {
            itemStack.set(ModDataComponents.LOADED, true);
            return;
        }
        val bullets = player.inventory.firstOrNull{ it.item == ModItems.CARTRIDGE } ?: return;
        itemStack.set(ModDataComponents.LOADED, true)
        player.cooldowns.addCooldown(itemStack, COOLDOWN_TIME)
        bullets.shrink(1)
    }

    private fun shoot(level: Level, player: Player, itemStack: ItemStack) {
        if (level.isClientSide) return
        val bullet = Projectile(level, player)
        bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0f, 10.0f, 0.0f)
        level.addFreshEntity(bullet)
        if(player.gameMode() != GameType.CREATIVE) {
            itemStack.set(ModDataComponents.LOADED, false)
            player.cooldowns.addCooldown(itemStack, COOLDOWN_TIME)
        }
    }
}
