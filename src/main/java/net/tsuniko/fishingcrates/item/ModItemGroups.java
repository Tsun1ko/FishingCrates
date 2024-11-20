package net.tsuniko.fishingcrates.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tsuniko.fishingcrates.FishingCrates;
import net.tsuniko.fishingcrates.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup FISHING_CRATES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(FishingCrates.MOD_ID, "fishing_crates"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fishing_crates"))
                    .icon(() -> new ItemStack(Items.COD)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.WOODEN_CRATE);
                    }).build());

    public static void registerItemGroups() {
        FishingCrates.LOGGER.info("Registering Item Groups for " + FishingCrates.MOD_ID);
    }
}
