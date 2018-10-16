package com.alexmassenzio.EABot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Game.GameType;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class EABot extends ListenerAdapter
{
	static String prefix;

	public static void main(String[] args)
	{
		prefix = ">";
		
		// Read token from config file
		List<String> config = null;
		try {
			config = Files.readAllLines(Paths.get("config.txt"));
		} catch (IOException ignored) { }
		
		String token = config.get(0);
		
		//Create jda builder and initialize values
		JDABuilder builder = new JDABuilder(AccountType.BOT);
		builder.setGame(Game.of(GameType.WATCHING, "your every move."));
		builder.setStatus(OnlineStatus.ONLINE);
		builder.setToken(token);
		builder.addEventListener(new ReadyListener());
		builder.addEventListener(new MessageReceivedListener());
		
		try {
			JDA api = builder.build();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
