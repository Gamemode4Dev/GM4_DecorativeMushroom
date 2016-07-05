package co.gm4.GM4_DecorativeMushroom.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import co.gm4.GM4_DecorativeMushroom.DecorativeMushroom;

public class BookDrop implements Listener {

	private DecorativeMushroom plugin;
	
	public BookDrop(DecorativeMushroom plugin)
	{
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onBookDrop(PlayerDropItemEvent event)
	{
		//TODO: Deactivation message if the item was the only valid book and quill in the inventory.
	}
}
