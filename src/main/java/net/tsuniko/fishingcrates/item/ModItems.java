package net.tsuniko.fishingcrates.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tsuniko.fishingcrates.FishingCrates;

public class ModItems {

    private  static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FishingCrates.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FishingCrates.LOGGER.info("Registering Mod Items for " + FishingCrates.MOD_ID);
    }
}