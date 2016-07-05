package co.gm4.GM4_DecorativeMushroom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Project: GM4_DecorativeMushroom
 * Author: OSX
 * Date: Jul 05 2016
 * Website (of GM4): http://gm4.co
 */

public class DecorativeMushroom extends JavaPlugin {
	
	public static String[] bookPhrases = {"east","north","northeast","northwest","south","southeast","southwest","west","inside","allstem","stem"};
	
	public ArrayList<UUID> activatedPlayers = new ArrayList<>();
	public HashMap<UUID, String> activationPhrase = new HashMap<>();
	
	//TODO: Tellraw messages
	public String activationMessage = "Decorative Mushrooms has been activated!";
	public String deactivationMessage = "Decorative Mushrooms has been deactivated!";
	
	@Override
	public void onEnable()
	{
		//TODO: Config and achievements
		for(Player p : Bukkit.getServer().getOnlinePlayers())
		{
			this.validateItem(p);
		}
		
		new InstantiateEvents(this);
	}
	
	@Override
	public void onDisable()
	{
		for(int i = 0; i < activatedPlayers.size(); i++)
		{
			for(Player p : Bukkit.getServer().getOnlinePlayers())
			{
				this.deactivate(p);
			}
		}
	}
	
	public boolean isValidBook(ItemStack book, UUID uuid)
	{
		if(!(book.getType().equals(Material.BOOK_AND_QUILL)))
		{
			return false;
		}
		
		ItemMeta itemMeta = book.getItemMeta();
		
		if(!(itemMeta instanceof BookMeta))
		{
			return false;
		}
		
		BookMeta bookMeta = (BookMeta) itemMeta;
		
		if(bookMeta.getPageCount() > 1)
			return false;
		
		String text = bookMeta.getPages().get(0);
		
		for(int i = 0; i < DecorativeMushroom.bookPhrases.length; i++)
		{
			if(text.equalsIgnoreCase(DecorativeMushroom.bookPhrases[i]))
			{
				
				this.activationPhrase.put(uuid, bookPhrases[i]);
				return true;
			}
		}
		return false;
	}
	
	public void validateItem(Player player)
	{
		PlayerInventory inv = player.getInventory();
		Collection<? extends ItemStack> books = inv.all(Material.BOOK_AND_QUILL).values();
		
		boolean validBook = false;
		for(ItemStack i : books)
		{
			if(isValidBook(i, player.getUniqueId()))
			{
				validBook = true;
				break;
			}
		}
		
		if(!validBook)
		{
			deactivate(player);
		}
		
		ItemStack tool = inv.getItemInMainHand();
		if(tool.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH))
		{
			activate(player);
			return;
		}
		
		deactivate(player);
	}
	
	private void activate(Player player)
	{
		this.activate(player, true);
	}
	
	private void activate(Player player, boolean message)
	{
		if(!(this.activatedPlayers.contains(player.getUniqueId())))
		{
			this.activatedPlayers.add(player.getUniqueId());
			
			if(message)
			{
				//TODO: Tellraw support
				player.sendMessage(activationMessage);
			}
		}
	}
	
	private void deactivate(Player player)
	{
		this.deactivate(player, true);
	}
	
	private void deactivate(Player player, boolean message)
	{
		if(this.activatedPlayers.contains(player.getUniqueId()))
		{
			this.activatedPlayers.remove(player.getUniqueId());
			this.activatedPlayers.trimToSize();
			
			this.activationPhrase.remove(player.getUniqueId());
			
			if(message)
			{
				//TODO: Tellraw support
				player.sendMessage(deactivationMessage);
			}
		}
	}
}
