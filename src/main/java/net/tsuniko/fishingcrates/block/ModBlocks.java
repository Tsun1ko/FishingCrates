package net.tsuniko.fishingcrates.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.tsuniko.fishingcrates.FishingCrates;

public class ModBlocks {
    public static final Block WOODEN_CRATE = registerBlock("wooden_crate",
            new Crate(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block IRON_CRATE = registerBlock("iron_crate",
            new Crate(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block GOLDEN_CRATE = registerBlock("golden_crate",
            new Crate(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.NETHERITE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FishingCrates.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(FishingCrates.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        FishingCrates.LOGGER.info("Registering Mod Blocks for " + FishingCrates.MOD_ID);
    }
}
