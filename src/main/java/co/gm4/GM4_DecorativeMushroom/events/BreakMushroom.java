package co.gm4.GM4_DecorativeMushroom.events;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
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
		Player player = event.getPlayer();
		
		if(!(player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)))
		{
			if(plugin.activatedPlayers.contains(player.getUniqueId()))
			{
				plugin.validateItem(player);
			}
			return;
		}
		
		plugin.validateItem(player);
		
		if(!(plugin.activatedPlayers.contains(player.getUniqueId())))
		{
			return;
		}
		
		
	}
	
}
