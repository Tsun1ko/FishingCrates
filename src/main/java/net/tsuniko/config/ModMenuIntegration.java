package net.tsuniko.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.IntegerFieldControllerBuilder;
import net.minecraft.network.chat.Component;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parentSreen -> YetAnotherConfigLib.createBuilder()
                .title(Component.literal("Fishing Crates Config"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("Fishing Crates Config"))
                        .option(Option.<Integer>createBuilder()
                                .name(Component.literal("Wooden Crate Weight"))
                                .description(OptionDescription.of(Component.literal("Higher Weight = Higher chance to fish up")))
                                .binding(1, () -> ModConfig.woodenCrateWeight, newVal -> ModConfig.woodenCrateWeight = newVal)
                                .controller(opt -> IntegerFieldControllerBuilder.create(opt).min(1).max(100))
                                .build())
                        .option(Option.<Integer>createBuilder()
                                .name(Component.literal("Iron Crate Weight"))
                                .description(OptionDescription.of(Component.literal("Higher Weight = Higher chance to fish up")))
                                .binding(4, () -> ModConfig.ironCrateWeight, newVal -> ModConfig.ironCrateWeight = newVal)
                                .controller(opt -> IntegerFieldControllerBuilder.create(opt).min(1).max(100))
                                .build())
                        .build())
                .save(() -> ModConfig.HANDLER.save())
                .build()
                .generateScreen(parentSreen);
    }
}
