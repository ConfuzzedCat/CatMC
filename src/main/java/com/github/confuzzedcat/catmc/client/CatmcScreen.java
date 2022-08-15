package com.github.confuzzedcat.catmc.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.github.confuzzedcat.catmc.client.CatmcClient.CLIENT;

public class CatmcScreen extends Screen {
    private final Screen Parent;
    private final GameOptions Settings;

    protected CatmcScreen(Text title, Screen parent, GameOptions gameOptions) {
        super(title);
        this.Parent = parent;
        this.Settings = gameOptions;
    }

    @Override
    protected void init() {
        super.init();
        this.addDrawableChild(
                new ButtonWidget(0, 0, 50, 20, Text.of("Back"), button -> {
                    CLIENT.setScreen(Parent);
                }));
    }
}
