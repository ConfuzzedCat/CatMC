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
    public static int FlyDetectionBypass = 0;
    public static Boolean AutoFish = false;
    public static Boolean Fly = false;
    public static Screen LastScene;
    @Override
    public void onInitializeClient() {
        Log.info("CatMC started.");
        ScreenEvents.AFTER_INIT.register(
                (client, screen, scaledWidth, scaledHeight) -> {

                    /*if(screen instanceof TitleScreen){
                        Screens.getButtons(screen).add(new ButtonWidget((int)Math.ceil(scaledWidth/10/2), (int)Math.ceil(scaledHeight/10/2), 50, 20, Text.of("CatMC"), button -> {
                            Log.info("Button Clicked.");
                            CLIENT.setScreenAndRender(new CatmcScreen(Text.of("CatMC - Menu"), screen, CLIENT.options));

                        }));
                    }*/
                    if(screen instanceof GameMenuScreen){
                        Screens.getButtons(screen).add(new ButtonWidget((int)Math.ceil(scaledWidth/10/2), (int)Math.ceil(scaledHeight/10/2), 50, 20, Text.of("CatMC"), button -> {
                            Log.info("Button Clicked.");
                            CLIENT.setScreenAndRender(new CatmcScreen(Text.of("CatMC - Menu"), screen, CLIENT.options));

                        }));
                    }


                });
    }
    public static void tick() {

    }
}
