package co.gm4.GM4_DecorativeMushroom.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;

import co.gm4.GM4_DecorativeMushroom.DecorativeMushroom;

public class BookStow implements Listener {

	private DecorativeMushroom plugin;
	
	public BookStow(DecorativeMushroom plugin)
	{
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onInventoryInteract(InventoryInteractEvent event)
	{
		//TODO: If the player adds a valid book and quill to his or her inventory, send the activation message.
		//TODO: If the player removes the only valid book and quill from his or her inventory, send the deactivation message.
	}
}
