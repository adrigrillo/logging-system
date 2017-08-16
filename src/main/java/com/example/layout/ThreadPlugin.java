package com.example.layout;

import java.util.Random;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.StrLookup;

@Plugin(name = "thread", category = StrLookup.CATEGORY)
public class ThreadPlugin implements StrLookup {
	public String lookup(String key) {
		return Integer.toString((new Random()).nextInt(10000 + 1), Character.MAX_RADIX);
	}

	public String lookup(LogEvent event, String key) {
		return Integer.toString((new Random()).nextInt(10000 + 1), Character.MAX_RADIX);
	}
}
