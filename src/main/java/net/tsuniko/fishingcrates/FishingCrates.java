package net.tsuniko.fishingcrates;

import net.fabricmc.api.ModInitializer;

import net.tsuniko.fishingcrates.block.ModBlocks;
import net.tsuniko.fishingcrates.item.ModItemGroups;
import net.tsuniko.fishingcrates.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FishingCrates implements ModInitializer {
	public static final String MOD_ID = "fishingcrates";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}