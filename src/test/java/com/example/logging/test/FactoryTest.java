package com.example.logging.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.cal10n.LocLogger;

import com.example.logging.IntLogger;

public class FactoryTest {

	@Test
	public void createFactoryWithoutLanguage() {
		LocLogger logger = IntLogger.get(FactoryTest.class);
		assertEquals("com.example.logging.test.FactoryTest", logger.getName());
	}
	
	@Test
	public void createFactoryWithLanguage() {
		LocLogger logger = IntLogger.get("es", FactoryTest.class);
		assertEquals("com.example.logging.test.FactoryTest", logger.getName());
	}
	
	 @Test
	 public void createFactoryWithLanguageAndRegion() {
	 LocLogger logger = IntLogger.get("es", "ES", FactoryTest.class);
	 assertEquals("com.example.logging.test.FactoryTest", logger.getName());
	 }
}
