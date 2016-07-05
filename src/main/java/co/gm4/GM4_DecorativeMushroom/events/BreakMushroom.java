package co.gm4.GM4_DecorativeMushroom.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import co.gm4.GM4_DecorativeMushroom.DecorativeMushroom;

public class BreakMushroom implements Listener {

	private DecorativeMushroom plugin;
	
	public BreakMushroom(DecorativeMushroom plugin)
	{
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onMushroomBroken(BlockBreakEvent event)
	{
		//TODO: Revalidate activation and apply the book and quill's design if correctly activated.
	}
	
}
