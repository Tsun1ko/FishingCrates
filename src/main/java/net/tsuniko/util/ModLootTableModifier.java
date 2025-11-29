package net.tsuniko.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.RegistryKey;
import net.tsuniko.block.ModBlocks;

public class ModLootTableModifier {
    private static final int UNCOMMON = 4;
    private static final int RARE = 1;

    private static final RegistryKey<LootTable> FISHING_FISH_ID = LootTables.FISHING_FISH_GAMEPLAY;
    private static final RegistryKey<LootTable> FISHING_TREASURE_ID = LootTables.FISHING_TREASURE_GAMEPLAY;

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((registryKey, builder, lootTableSource, wrapperLookup) -> {
            if (lootTableSource.isBuiltin() && FISHING_FISH_ID.equals(registryKey)) {
                builder.modifyPools(pool -> {
                    pool.with(ItemEntry.builder(ModBlocks.WOODEN_CRATE).weight(UNCOMMON));
                    pool.with(ItemEntry.builder(ModBlocks.IRON_CRATE).weight(RARE));
                });
            }
            if (lootTableSource.isBuiltin() && FISHING_TREASURE_ID.equals(registryKey)) {
                builder.modifyPools(pool -> {
                    pool.with(ItemEntry.builder(ModBlocks.GOLDEN_CRATE));
                });
            }
        }));
    }
}
