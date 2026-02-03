package net.obsc.OBSCTweaks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import net.obsc.OBSCTweaks.OBSCTweaks;

public class Events implements Listener {

    public void Print(String fart)
    {
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "[" + ChatColor.LIGHT_PURPLE + "ObscureTweaks" + ChatColor.WHITE + "] " +  ChatColor.WHITE + fart);
    }

    @EventHandler
    public void InventoryOpen(InventoryOpenEvent event)
    {
        Inventory inventory = event.getInventory();
        if(inventory.getType() == InventoryType.ENCHANTING)
        {
            inventory.setItem(1, new ItemStack(Material.LAPIS_LAZULI, 3));
            Print("Added Lapis");
        }
    }

    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent event) {
        Print("attempting cancel of InventoryClickEvent");
        if( event.getClickedInventory() == null ) {
            return;
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
            Print("removing lapis from inv");
            Inventory inv = event.getInventory();
            inv.setItem(1, null);
        }
    }
}
