package net.tsuniko.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.tsuniko.FishingCrates;

public class ModBlocks {
    public static final Block WOODEN_CRATE = register(
            new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)),
            "wooden_crate",
            true);

    public static final Block IRON_CRATE = register(
            new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)),
            "iron_crate",
            true);

    public static final Block GOLDEN_CRATE = register(
            new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK).sound(SoundType.NETHERITE_BLOCK)),
            "golden_crate",
            true);

    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(FishingCrates.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new net.minecraft.world.item.Item.Properties());
            Registry.register(BuiltInRegistries.ITEM, id, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void init() {
        FishingCrates.LOGGER.info("Registering Mod Blocks");

    }
}
