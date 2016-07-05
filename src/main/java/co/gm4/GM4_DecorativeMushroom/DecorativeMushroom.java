package co.gm4.GM4_DecorativeMushroom;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Project: GM4_DecorativeMushroom
 * Author: OSX
 * Date: Jul 05 2016
 * Website (of GM4): http://gm4.co
 */

public class DecorativeMushroom extends JavaPlugin {

	@Override
	public void onEnable()
	{
		//TODO: Config and achievements
		
		new InstantiateEvents(this);
	}
	
}
