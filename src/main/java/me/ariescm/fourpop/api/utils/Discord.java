package me.ariescm.fourpop.api.utils;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import me.ariescm.fourpop.impl.Main;

public class Discord {
    private static String discordID = "935200550679629837";
    private static DiscordRichPresence discordRichPresence = new DiscordRichPresence();
    private static DiscordRPC discordRPC = DiscordRPC.INSTANCE;

    public static void startRPC() {
        DiscordEventHandlers eventHandlers = new DiscordEventHandlers();
        eventHandlers.disconnected = ((var1, var2) -> System.out.println("Discord RPC disconnected, var1: " + var1 + ", var2: " + var2));
        discordRPC.Discord_Initialize(discordID, eventHandlers, true, null);
        
        discordRichPresence.startTimestamp = System.currentTimeMillis() / 1000L;
        discordRichPresence.largeImageKey = "large";
        discordRichPresence.largeImageText = "4pop strong";
        discordRichPresence.state = "pwning newbs with 4pop v" + Main.version;
        discordRPC.Discord_UpdatePresence(discordRichPresence);
    }

    public static void stopRPC() {
        discordRPC.Discord_Shutdown();
        discordRPC.Discord_ClearPresence();
    }
}