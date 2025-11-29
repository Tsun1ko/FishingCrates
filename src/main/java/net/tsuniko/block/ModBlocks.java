package net.tsuniko.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tsuniko.FishingCrates;

public class ModBlocks {
    public static final Block WOODEN_CRATE = register(
            new CrateBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)),
            "wooden_crate",
            true);

    public static final Block IRON_CRATE = register(
            new CrateBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.NETHERITE)),
            "iron_crate",
            true);

    public static final Block GOLDEN_CRATE = register(
            new CrateBlock(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.NETHERITE)),
            "golden_crate",
            true);

    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(FishingCrates.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void init() {
        FishingCrates.LOGGER.info("Registering Mod Blocks");

    }
}
