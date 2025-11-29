package net.tsuniko.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tsuniko.FishingCrates;
import net.tsuniko.block.ModBlocks;

public class ModItemGroup {
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(FishingCrates.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.GOLDEN_CRATE.asItem()))
            .displayName(Text.translatable("itemgroup.fishing_crates"))
            .build();

    public static void init() {
        FishingCrates.LOGGER.info("Registering Mod Item Groups");

        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlocks.WOODEN_CRATE);
            itemGroup.add(ModBlocks.IRON_CRATE);
            itemGroup.add(ModBlocks.GOLDEN_CRATE);
        });
    }
}
