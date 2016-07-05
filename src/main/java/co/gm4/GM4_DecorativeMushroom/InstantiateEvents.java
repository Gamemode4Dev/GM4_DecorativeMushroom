package co.gm4.GM4_DecorativeMushroom;

import co.gm4.GM4_DecorativeMushroom.events.BookDrop;
import co.gm4.GM4_DecorativeMushroom.events.BookPickup;
import co.gm4.GM4_DecorativeMushroom.events.BookStow;
import co.gm4.GM4_DecorativeMushroom.events.BreakMushroom;
import co.gm4.GM4_DecorativeMushroom.events.HoldAxe;

public final class InstantiateEvents {

	public InstantiateEvents(DecorativeMushroom plugin)
	{
		new BookDrop(plugin);
		new BookPickup(plugin);
		new BookStow(plugin);
		new BreakMushroom(plugin);
		new HoldAxe(plugin);
	}
	
}
