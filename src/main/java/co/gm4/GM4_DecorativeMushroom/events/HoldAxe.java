package co.gm4.GM4_DecorativeMushroom.events;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
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
		Player player = event.getPlayer();
		
		if(player.getInventory().getItem(event.getPreviousSlot()).getItemMeta().hasEnchant(Enchantment.SILK_TOUCH))
		{
			if(!(player.getInventory().getItem(event.getNewSlot()).getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)))
			{
				plugin.validateItem(player);
			}
			return;
		}
		
		if(player.getInventory().getItem(event.getNewSlot()).getItemMeta().hasEnchant(Enchantment.SILK_TOUCH))
		{
			plugin.validateItem(player);
		}
	}
}
