package net.tsuniko.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.tsuniko.FishingCrates;

import java.util.function.Function;

public class ModBlocks {
    public static final Block WOODEN_CRATE = register(
            "wooden_crate",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.OAK_WOOD).sounds(BlockSoundGroup.WOOD),
            true);

    public static final Block IRON_CRATE = register(
            "iron_crate",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.NETHERITE),
            true);

    public static final Block GOLDEN_CRATE = register(
            "golden_crate",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.NETHERITE),
            true);

    public static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(Registries.BLOCK.getKey(), Identifier.of(FishingCrates.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(FishingCrates.MOD_ID, name));
    }

    public static void init() {
        FishingCrates.LOGGER.info("Registering Mod Blocks");
    }
}
