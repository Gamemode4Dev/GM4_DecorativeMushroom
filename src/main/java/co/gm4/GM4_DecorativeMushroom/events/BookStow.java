package co.gm4.GM4_DecorativeMushroom.events;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import co.gm4.GM4_DecorativeMushroom.DecorativeMushroom;

public class BookStow implements Listener {

	private DecorativeMushroom plugin;
	
	public BookStow(DecorativeMushroom plugin)
	{
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onInventoryInteract(InventoryClickEvent event)
	{
		HumanEntity who = event.getWhoClicked();
		if(!(who instanceof Player)) return;
		Player player = (Player) who;
		
		ItemStack currentItem = event.getCurrentItem();
		if(!(currentItem.equals(null)))
		{
			if(currentItem.getType().equals(Material.BOOK_AND_QUILL))
			{
				plugin.validateItem(player);
			}
			return;
		}
		
		if(!(event.getInventory().getType().equals(InventoryType.PLAYER)) && event.getView().getItem(event.getRawSlot()).getType().equals(Material.BOOK_AND_QUILL))
		{
			plugin.validateItem(player);
		}
	}
}
