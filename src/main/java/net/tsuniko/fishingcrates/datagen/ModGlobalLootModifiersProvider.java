package net.tsuniko.fishingcrates.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.tsuniko.fishingcrates.FishingCrates;
import net.tsuniko.fishingcrates.block.ModBlocks;
import net.tsuniko.fishingcrates.item.ModItems;
import net.tsuniko.fishingcrates.loot.AddItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, FishingCrates.MOD_ID);
    }

    @Override
    protected void start() {
        add("wooden_crate_from_fishing", new AddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.35f).build(),
                new LootTableIdCondition.Builder(ResourceLocation.parse("gameplay/fishing")).build()}, ModBlocks.WOODEN_CRATE.get().asItem()));
        add("iron_crate_from_fishing", new AddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.15f).build(),
                new LootTableIdCondition.Builder(ResourceLocation.parse("gameplay/fishing")).build() }, ModBlocks.IRON_CRATE.get().asItem()));
        add("golden_crate_from_treasure_fishing", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(ResourceLocation.parse("gameplay/fishing/treasure")).build()}, ModBlocks.GOLDEN_CRATE.get().asItem()));
    }
}
