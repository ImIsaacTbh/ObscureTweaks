package net.obsc.OBSCTweaks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import net.obsc.OBSCTweaks.OBSCTweaks;

import java.util.Dictionary;
import java.util.Map;

public class Events implements Listener {

    public void Print(String fart)
    {
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "[" + ChatColor.LIGHT_PURPLE + "ObscureTweaks" + ChatColor.WHITE + "] " +  ChatColor.WHITE + fart);
    }

    @EventHandler
    public void PrepareItemEnchantEvent(PrepareItemEnchantEvent e)
    {
        var offers = e.getOffers();
        for (int i = 0; i < offers.length; i++)
        {
            offers[i].setCost(2^i);
        }
    }

    @EventHandler
    public void InventoryOpen(InventoryOpenEvent event)
    {
        Inventory inventory = event.getInventory();
        if(inventory.getType() == InventoryType.ENCHANTING)
        {
            inventory.setItem(1, new ItemStack(Material.LAPIS_LAZULI, 3));
        }
    }

    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent event) {
        if( event.getClickedInventory() == null ) {
            return;
        }
        if(event.getAction() == InventoryAction.DROP_ALL_CURSOR)
        {
            if(event.getCurrentItem().getType() == Material.ENCHANTED_BOOK)
            {

            }
        }
        if(event.getClickedInventory().getType() == InventoryType.ENCHANTING) {
            if(event.getCurrentItem().getType() == Material.LAPIS_LAZULI) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void InventoryCloseEvent(InventoryCloseEvent event) {
        if(event.getInventory().getType() == InventoryType.ENCHANTING) {
            Inventory inv = event.getInventory();
            inv.setItem(1, null);
        }
    }
}
