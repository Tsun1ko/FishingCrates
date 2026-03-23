package net.tsuniko.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

import java.util.List;

public class CrateBlock extends Block {
    public CrateBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag options) {
        tooltip.add(Component.translatable("tooltip.fishing_crates.crate_info").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(stack, context, tooltip, options);
    }
}
