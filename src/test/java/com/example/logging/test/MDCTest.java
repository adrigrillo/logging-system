package com.example.logging.test;

import static org.junit.Assert.assertEquals;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.MDC;

import com.example.logging.ContextData;

public class MDCTest {

	@Test
	public void insertEntryTest() {
		Map.Entry<String, String> entry = new AbstractMap.SimpleEntry<String, String>("idInstalacion", "djs324");
		ContextData.add(entry);
		assertEquals("djs324", MDC.get("idInstalacion"));
	}
	
	@Test
	public void insertMapTest() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("idInstalacion", "djfo123");
		map.put("id2", "4533s");
		ContextData.add(map);
		assertEquals(2, MDC.getCopyOfContextMap().size());
		assertEquals("djfo123", MDC.get("idInstalacion"));
		assertEquals("4533s", MDC.get("id2"));
	}
}
