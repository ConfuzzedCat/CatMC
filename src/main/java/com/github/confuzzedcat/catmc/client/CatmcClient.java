package com.github.confuzzedcat.catmc.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class CatmcClient implements ClientModInitializer {
    public static final Logger Log = LoggerFactory.getLogger("CatMC");
    public static final MinecraftClient CLIENT = MinecraftClient.getInstance();

    @Override
    public void onInitializeClient() {
        Log.info("This is a test log.");
        ScreenEvents.AFTER_INIT.register(
                (client, screen, scaledWidth, scaledHeight) -> {
                    if(screen instanceof TitleScreen){
                        Screens.getButtons(screen).add(new ButtonWidget((int)Math.ceil(scaledWidth/10/2), (int)Math.ceil(scaledHeight/10/2), 50, 20, Text.of("CatMC"), button -> Log.info("Button Clicked.")));
                    }
                    if(screen instanceof GameMenuScreen){
                        Screens.getButtons(screen).add(new ButtonWidget(0, 0, 50, 20, Text.of("CatMC"), button -> Log.info("Button Clicked.")));
                    }
                    if(screen instanceof CatmcScreen){
                        Screens.getButtons(screen).add(new ButtonWidget(0, 0, 50, 20, Text.of("Back"), button -> {

                        }));
                    }

                });
    }
    public static void tick() {
    }
}
