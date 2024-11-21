package net.tsuniko.fishingcrates.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.util.Identifier;
import net.tsuniko.fishingcrates.block.ModBlocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FishingLootTableModifier {
    private static final int UNCOMMON = 4;
    private static final int RARE = 1;

    private static final Identifier FISHING_FISH_ID =
            new Identifier("minecraft", "gameplay/fishing/fish");
    private static final Identifier FISHING_TREASURE_ID =
            new Identifier("minecraft", "gameplay/fishing/treasure");

    public static void modifyLootTables() {
        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if (id.equals(FISHING_FISH_ID)) {
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));

                entries.add(ItemEntry.builder(ModBlocks.WOODEN_CRATE).weight(UNCOMMON).build());
                entries.add(ItemEntry.builder(ModBlocks.IRON_CRATE).weight(RARE).build());

                LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }

            if (id.equals(FISHING_TREASURE_ID)) {
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));

                entries.add(ItemEntry.builder(ModBlocks.GOLDEN_CRATE).weight(RARE).build());

                LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }

            return null;
        });
    }
}
