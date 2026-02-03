package net.obsc.OBSCTweaks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class OBSCTweaks extends JavaPlugin {
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage( ChatColor.WHITE + "[" + ChatColor.LIGHT_PURPLE + "ObscureTweaks" + ChatColor.WHITE + "] " + ChatColor.GREEN + "Enabled " + ChatColor.WHITE + this.getName());
        Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
        //Bukkit.getLogger().info();
    }
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "[" + ChatColor.LIGHT_PURPLE + "ObscureTweaks" + ChatColor.WHITE + "] " +  ChatColor.RED + "Disabled " + ChatColor.WHITE + this.getName());
    }
}
