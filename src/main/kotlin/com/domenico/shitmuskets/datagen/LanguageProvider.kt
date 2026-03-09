package com.domenico.shitmuskets.datagen

import com.domenico.shitmuskets.items.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.core.Holder
import net.minecraft.core.HolderLookup
import java.util.concurrent.CompletableFuture

class LanguageProvider(output: FabricDataOutput, registryLookup: CompletableFuture<HolderLookup.Provider>) : FabricLanguageProvider(output, registryLookup) {
    override fun generateTranslations(
        p0: HolderLookup.Provider,
        p1: TranslationBuilder
    ) {
        p1.add(ModItems.MUSKET, "Musket")
    }
}