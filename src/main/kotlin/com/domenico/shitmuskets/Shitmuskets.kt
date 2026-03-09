package com.domenico.shitmuskets

import com.domenico.shitmuskets.items.ModDataComponents
import com.domenico.shitmuskets.items.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object Shitmuskets : ModInitializer {
	const val MOD_ID = "shitmuskets"
    private val logger = LoggerFactory.getLogger("shitmuskets")

	override fun onInitialize() {
		ModDataComponents.initialize()
		ModItems.initialize();
	}
}