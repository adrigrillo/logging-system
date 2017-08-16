package com.example.logging;

import java.util.Locale;
import java.util.Properties;

import org.slf4j.cal10n.LocLogger;
import org.slf4j.cal10n.LocLoggerFactory;

import ch.qos.cal10n.IMessageConveyor;
import ch.qos.cal10n.MessageConveyor;

public class IntLogger {

	// Logger for the class log
	private static IMessageConveyor mc = new MessageConveyor(Locale.ENGLISH);
	private static LocLoggerFactory fact = new LocLoggerFactory(mc);
	private static LocLogger log = fact.getLocLogger(IntLogger.class);

	/**
	 * Creates a Logger with the locale configured in the computer
	 * 
	 * @param clazz
	 *            Class where the Logger is instanced
	 * @return A LocLogger instance by class
	 */
	public static LocLogger get(Class<?> clazz) {
		IMessageConveyor messageConveyor = new MessageConveyor(getLanguage());
		LocLoggerFactory factory = new LocLoggerFactory(messageConveyor);
		return factory.getLocLogger(clazz);
	}

	/**
	 * Creates a Logger with the language indicated with its language code, this
	 * method does not consider the region.
	 * 
	 * @param language
	 *            An ISO 639 alpha-2 or alpha-3 language code, or a language subtag
	 *            up to 8 characters in length. See the Locale class description
	 *            about valid language values.
	 * @param clazz
	 *            Class where the Logger is instanced
	 * @return A LocLogger instance by class
	 */
	public static LocLogger get(String language, Class<?> clazz) {
		if (language == null || language.isEmpty()) {
			log.warn(InternalLogMessages.LANGUAGENOTFOUND);
			return get(clazz);
		}
		IMessageConveyor messageConveyor = new MessageConveyor(new Locale(language));
		LocLoggerFactory factory = new LocLoggerFactory(messageConveyor);
		return factory.getLocLogger(clazz);
	}

	/**
	 * Creates a Logger with the locale indicated from the language code and the
	 * country code indicated.
	 * 
	 * @param language
	 *            An ISO 639 alpha-2 or alpha-3 language code, or a language subtag
	 *            up to 8 characters in length. See the Locale class description
	 *            about valid language values.
	 * @param country
	 *            An ISO 3166 alpha-2 country code or a UN M.49 numeric-3 area code.
	 *            See the Locale class description about valid country values.
	 * @param clazz
	 *            Class where the Logger is instanced
	 * @return A LocLogger instance by class
	 */
	public static LocLogger get(String language, String country, Class<?> clazz) {
		if (country == null || country.isEmpty()) {
			log.warn(InternalLogMessages.COUNTRYNOTFOUND);
			return get(language, clazz);
		}
		IMessageConveyor messageConveyor = new MessageConveyor(new Locale(language, country));
		LocLoggerFactory factory = new LocLoggerFactory(messageConveyor);
		return factory.getLocLogger(clazz);
	}

	
	/**
	 * Method that return the locale to use in the logger after searching for it in the config.properties file.
	 * In case of error English is established as default language.
	 * 
	 * @return The locale established in the properties file
	 */
	private static Locale getLanguage() {
		Properties prop = new Properties();
		String property = "log.language";
		try {
			prop.load(IntLogger.class.getClassLoader().getResourceAsStream("config.properties"));
			String value = prop.getProperty(property);
			if (value != null && !value.isEmpty()) {
				log.debug(InternalLogMessages.LOCALEREADOK, value);
				String locale [] = value.split("_");
				return locale.length == 1 ? new Locale(locale[0]) : new Locale(locale[0], locale[1]);
			} else {
				log.warn(InternalLogMessages.ERRORREADINGPROP, property);
				return Locale.ENGLISH;
			}
		} catch (Exception ex) {
			log.warn(InternalLogMessages.ERRORREADINGPROPFILE, property, ex);
			return Locale.ENGLISH;
		}
	}
}
