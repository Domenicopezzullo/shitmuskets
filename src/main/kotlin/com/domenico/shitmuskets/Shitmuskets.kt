package com.domenico.shitmuskets

import com.domenico.shitmuskets.items.ModDataComponents
import com.domenico.shitmuskets.items.ModEntities
import com.domenico.shitmuskets.items.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object Shitmuskets : ModInitializer {
	const val MOD_ID = "shitmuskets"
    private val LOGGER = LoggerFactory.getLogger("shitmuskets")

	override fun onInitialize() {
		ModEntities.initialize();
		ModDataComponents.initialize()
		ModItems.initialize();
	}
}
