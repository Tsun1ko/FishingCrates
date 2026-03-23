package net.tsuniko.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.resources.ResourceKey;
import net.tsuniko.block.ModBlocks;

public class ModLootTableModifier {
    private static final int UNCOMMON = 4;
    private static final int RARE = 1;

    private static final ResourceKey<LootTable> FISHING_FISH_ID = BuiltInLootTables.FISHING_FISH;
    private static final ResourceKey<LootTable> FISHING_TREASURE_ID = BuiltInLootTables.FISHING_TREASURE;

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((registryKey, builder, lootTableSource, wrapperLookup) -> {
            if (lootTableSource.isBuiltin() && FISHING_FISH_ID.equals(registryKey)) {
                builder.modifyPools(pool -> {
                    pool.add(LootItem.lootTableItem(ModBlocks.WOODEN_CRATE).setWeight(UNCOMMON));
                    pool.add(LootItem.lootTableItem(ModBlocks.IRON_CRATE).setWeight(RARE));
                });
            }
            if (lootTableSource.isBuiltin() && FISHING_TREASURE_ID.equals(registryKey)) {
                builder.modifyPools(pool -> {
                    pool.add(LootItem.lootTableItem(ModBlocks.GOLDEN_CRATE));
                });
            }
        }));
    }
}
