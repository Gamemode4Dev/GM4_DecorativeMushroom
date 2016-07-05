package co.gm4.GM4_DecorativeMushroom;

import java.util.ArrayList;
import java.util.UUID;

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
	
	public static String[] bookPhrases = {};
	
	public ArrayList<UUID> activatedPlayers;
	
	//TODO: Tellraw messages
	public String activationMessage = "Decorative Mushrooms has been activated!";
	public String deactivationMessage = "Decorative Mushrooms has been deactivated!";
	
	@Override
	public void onEnable()
	{
		//TODO: Config and achievements
		//TODO: Test for activation at start up.
		
		new InstantiateEvents(this);
	}
	
	@Override
	public void onDisable()
	{
		//TODO: Tell all activated players that it is deactivated now.
	}
	
	public static boolean isValidBook(ItemStack book)
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
		
		String text = bookMeta.getPage(0);
		
		for(int i = 0; i < bookPhrases.length; i++)
		{
			if(text.equalsIgnoreCase(DecorativeMushroom.bookPhrases[i]))
			{
				return true;
			}
		}
		return false;
	}
	
	public void validateItem(Player player)
	{
		//TODO: Search inventory for a book and quill and axe and act accordingly.
	}
}
