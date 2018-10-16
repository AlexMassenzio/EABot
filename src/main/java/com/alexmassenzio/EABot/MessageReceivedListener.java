package com.alexmassenzio.EABot;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageReceivedListener extends ListenerAdapter
{
	public void onReady(ReadyEvent r)
	{
		System.out.println("Message receiving ready!");
	}
	
	public void onMessageReceived(MessageReceivedEvent e)
	{
		if(!e.getMessage().getContentRaw().startsWith(EABot.prefix)) return;
		if(e.getChannelType() == ChannelType.PRIVATE)
		{
			System.out.println(String.format("[DM] %s#%s: %s", e.getAuthor().getName(), e.getAuthor().getDiscriminator(), e.getMessage().getContentRaw()));
		}
		else
		{
			System.out.println(String.format("[%s][%s] %s#%s: %s", e.getGuild().getName(), e.getChannel().getName(), e.getAuthor().getName(), e.getAuthor().getDiscriminator(), e.getMessage().getContentRaw()));
		}
		
		String command = e.getMessage().getContentStripped().replace(EABot.prefix, "").split(" ")[0];
		String[] args = e.getMessage().getContentRaw().replace(EABot.prefix, "").replace(command, "").split(" ");
		
		if(command.equalsIgnoreCase("helloworld"))
		{
			e.getChannel().sendMessage("Hello, " + e.getAuthor().getName() + "!").queue();
		}
	}
}
