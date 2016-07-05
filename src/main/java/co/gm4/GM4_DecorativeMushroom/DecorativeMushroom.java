package co.gm4.GM4_DecorativeMushroom;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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
	
	public HashMap<UUID, String> activationPhrase = new HashMap<>();
	 
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
		if(this.activationPhrase.containsKey(player.getUniqueId()))
		{
			this.activationPhrase.remove(player.getUniqueId());
		}
		
		PlayerInventory inv = player.getInventory();
		Collection<? extends ItemStack> books = inv.all(Material.BOOK_AND_QUILL).values();
		
		for(ItemStack i : books)
		{
			if(isValidBook(i, player.getUniqueId()))
			{
				break;
			}
		}
	}
}
