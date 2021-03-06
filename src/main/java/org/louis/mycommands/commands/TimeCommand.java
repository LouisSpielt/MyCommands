package org.louis.mycommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TimeCommand implements CommandExecutor {


    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender; // palyer
        String world = player.getWorld().getName(); // get world name
        int wantedtime = Integer.parseInt(args[0]);  // get args 0 (/time 2000

        int currenttime = (int) Bukkit.getServer().getWorld(world).getTime(); // Nutze die Akutelle welt zeit

        int diff = 0;
        if (wantedtime <= currenttime) {
            diff = currenttime - wantedtime;
        } else {
            diff = wantedtime - currenttime;
        }
        sender.sendMessage("Differenz: " + diff);
        if (wantedtime > Bukkit.getServer().getWorld(world).getTime()) {

            for (int i = currenttime; i < wantedtime; i++) {
                Bukkit.getServer().getWorld(world).setTime(i);
            }

            return true;
        } else {
            for (int i = currenttime; i > wantedtime; i--) {
                Bukkit.getServer().getWorld(world).setTime(i);
            }
            return true;
        }
    }
}
