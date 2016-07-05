package co.gm4.GM4_DecorativeMushroom.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

import co.gm4.GM4_DecorativeMushroom.DecorativeMushroom;

public class HoldAxe implements Listener {

	private DecorativeMushroom plugin;
	
	public HoldAxe(DecorativeMushroom plugin)
	{
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerHeldChange(PlayerItemHeldEvent event)
	{
		//TODO: Activate / Deactivate depending on if the player has a silk axe.
	}
}
