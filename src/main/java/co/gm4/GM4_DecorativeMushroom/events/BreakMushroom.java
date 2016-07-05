package co.gm4.GM4_DecorativeMushroom.events;

import org.bukkit.Material;
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
		if(!(event.getBlock().getType().equals(Material.HUGE_MUSHROOM_1) || (event.getBlock().getType().equals(Material.HUGE_MUSHROOM_2))))
		{
			return;
		}
		
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
		
		//TODO: Actual Functionality
		player.sendMessage("Block set: \"" + plugin.activationPhrase.get(player.getUniqueId()) + "\"");
	}
	
}
