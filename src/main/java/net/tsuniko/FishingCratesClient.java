package net.tsuniko;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.tsuniko.block.ModBlocks;

public class FishingCratesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FishingCrates.LOGGER.info("Initialising Client");

        ItemTooltipCallback.EVENT.register((stack, context, type, tooltip) -> {
            if (stack.isOf(ModBlocks.WOODEN_CRATE.asItem()) ||
            stack.isOf(ModBlocks.IRON_CRATE.asItem()) ||
            stack.isOf(ModBlocks.GOLDEN_CRATE.asItem())) {
                tooltip.add(Text.translatable("tooltip.fishing_crates.crate_info").formatted(Formatting.DARK_GRAY));
            }
        });
    }
}
