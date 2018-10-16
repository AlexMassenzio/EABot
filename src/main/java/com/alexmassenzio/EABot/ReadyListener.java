package com.alexmassenzio.EABot;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter
{
	public void onReady(ReadyEvent r)
	{
		System.out.println("I'm online!");
	}
}
