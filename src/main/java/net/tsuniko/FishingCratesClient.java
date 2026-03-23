package net.tsuniko;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.tsuniko.block.ModBlocks;

public class FishingCratesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FishingCrates.LOGGER.info("Initialising Client");

        ItemTooltipCallback.EVENT.register((stack, context, type, tooltip) -> {
            if (stack.is(ModBlocks.WOODEN_CRATE.asItem()) ||
            stack.is(ModBlocks.IRON_CRATE.asItem()) ||
            stack.is(ModBlocks.GOLDEN_CRATE.asItem())) {
                tooltip.add(Component.translatable("tooltip.fishing_crates.crate_info").withStyle(ChatFormatting.DARK_GRAY));
            }
        });
    }
}
