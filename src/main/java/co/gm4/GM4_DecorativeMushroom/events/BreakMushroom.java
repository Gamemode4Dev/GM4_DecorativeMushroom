package co.gm4.GM4_DecorativeMushroom.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.material.Mushroom;
import org.bukkit.material.types.MushroomBlockTexture;

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
		Block block = event.getBlock();
		if(!(block.getType().equals(Material.HUGE_MUSHROOM_1) || (block.getType().equals(Material.HUGE_MUSHROOM_2))))
		{
			return;
		}
		
		Player player = event.getPlayer();
		
		if(!(player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)))
		{
			return;
		}
		
		plugin.validateItem(player);
		
		if(!(plugin.activationPhrase.keySet().contains(player.getUniqueId())))
		{
			return;
		}
		
		
		
		final Material mat = block.getType();
		
		block.setType(Material.AIR);
		
		final Location loc = block.getLocation();
		final String phrase = plugin.activationPhrase.get(player.getUniqueId());
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
		{
			@Override
			public void run()
			{
				Block block = loc.getBlock();
				block.setType(mat);
				
				BlockState state = block.getState();
				Mushroom mushroom = (Mushroom) state.getData();
				
				switch(phrase)
				{
				case "east":
					mushroom.setBlockTexture(MushroomBlockTexture.CAP_EAST);
					break;
				case "north":
					mushroom.setBlockTexture(MushroomBlockTexture.CAP_NORTH);
					break;
				case "northeast":
					mushroom.setBlockTexture(MushroomBlockTexture.CAP_NORTH_EAST);
					break;
				case "northwest":
					mushroom.setBlockTexture(MushroomBlockTexture.CAP_NORTH_WEST);
					break;
				case "south":
					mushroom.setBlockTexture(MushroomBlockTexture.CAP_SOUTH);
					break;
				case "southeast":
					mushroom.setBlockTexture(MushroomBlockTexture.CAP_SOUTH_EAST);
					break;
				case "southwest":
					mushroom.setBlockTexture(MushroomBlockTexture.CAP_SOUTH_WEST);
					break;
				case "west":
					mushroom.setBlockTexture(MushroomBlockTexture.CAP_WEST);
					break;
				case "inside":
					mushroom.setBlockTexture(MushroomBlockTexture.ALL_PORES);
					break;
				case "allstem":
					mushroom.setBlockTexture(MushroomBlockTexture.ALL_STEM);
					break;
				case "stem":
					mushroom.setBlockTexture(MushroomBlockTexture.STEM_SIDES);
					break;
				}
				
				state.setData(mushroom);
				state.update();
			}
		});
	}
	
}
