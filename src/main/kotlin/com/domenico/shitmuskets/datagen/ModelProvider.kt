package com.domenico.shitmuskets.datagen

import com.domenico.shitmuskets.Shitmuskets
import com.domenico.shitmuskets.items.ModItems
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.model.ItemModelUtils
import net.minecraft.client.data.models.model.ModelTemplates
import net.minecraft.resources.Identifier

class ModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(p0: BlockModelGenerators) {

    }

    override fun generateItemModels(p0: ItemModelGenerators) {
        p0.generateFlatItem(ModItems.MUSKET, ModelTemplates.FLAT_HANDHELD_ITEM)
        p0.generateFlatItem(ModItems.CARTRIDGE, ModelTemplates.FLAT_ITEM)
    }
}