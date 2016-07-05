package co.gm4.GM4_DecorativeMushroom.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import co.gm4.GM4_DecorativeMushroom.DecorativeMushroom;

public class BookPickup implements Listener {

	private DecorativeMushroom plugin;
	
	public BookPickup(DecorativeMushroom plugin)
	{
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onBookPickup(PlayerPickupItemEvent event)
	{
		Player player = event.getPlayer();
		
		if(!(event.getItem().getItemStack().getType().equals(Material.BOOK_AND_QUILL)))
			return;
		
		plugin.validateItem(player);
	}
	
}
