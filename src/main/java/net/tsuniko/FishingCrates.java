package net.tsuniko;

import net.fabricmc.api.ModInitializer;

import net.tsuniko.block.ModBlocks;
import net.tsuniko.item.ModItemGroup;
import net.tsuniko.util.ModLootTableModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FishingCrates implements ModInitializer {
	public static final String MOD_ID = "fishing_crates";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModBlocks.init();
        ModItemGroup.init();

        ModLootTableModifier.modifyLootTables();
	}
}