package com.domenico.shitmuskets.items.customs

import com.domenico.shitmuskets.items.ModEntities
import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.projectile.arrow.AbstractArrow
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.EntityHitResult

class Projectile(entityType: EntityType<Projectile>, level: Level) : AbstractArrow(entityType, level) {
    constructor(level: Level, shooter: LivingEntity) : this(ModEntities.BULLET, level) {
        setOwner(shooter)
        setPos(shooter.x, shooter.eyeY - 0.1, shooter.z)
    }

    override fun getDefaultPickupItem(): ItemStack = ItemStack.EMPTY
    override fun getDefaultGravity(): Double = 0.01;
    override fun onHitEntity(entityHitResult: EntityHitResult) {
        val level = level()
        if(level.isClientSide) return;
        val distance = distanceTo(entityHitResult.entity)
        val damage = when {
            distance < 10.0 -> 40.0f
            distance < 30.0 -> 20.0f
            distance < 60.0 -> 12.0f
            else -> 8.0f
        }
        entityHitResult.entity.hurtServer(level as ServerLevel, damageSources().generic(), damage)
        discard()
    }

    override fun onHitBlock(blockHitResult: BlockHitResult) {
        if(level().isClientSide) return;
        discard()
    }
}