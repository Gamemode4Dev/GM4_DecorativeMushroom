package co.gm4.GM4_DecorativeMushroom;

import co.gm4.GM4_DecorativeMushroom.events.BreakMushroom;

public class InstantiateEvents {

	public InstantiateEvents(DecorativeMushroom plugin)
	{
		new BreakMushroom(plugin);
		//new BookPickup(plugin);
		//new BookStow(plugin);
		//new HoldAxe(plugin);
		//new BookDrop(plugin);
	}
	
}
