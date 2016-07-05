package co.gm4.GM4_DecorativeMushroom;

import co.gm4.GM4_DecorativeMushroom.events.HoldAxe;

public class InstantiateEvents {

	public InstantiateEvents(DecorativeMushroom plugin)
	{
		new HoldAxe(plugin);
		//new BookPickup(plugin);
		//new BookStow(plugin);
		//new BreakMushroom(plugin);
		//new BookDrop(plugin);
	}
	
}
