package com.example.logging;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.MDC;
import org.slf4j.cal10n.LocLogger;

public class ContextData {

	private static LocLogger log = IntLogger.get(ContextData.class);

	/**
	 * Method to establish the context information in the log traces. It receives a
	 * map as entry and put its elements in the MDC, in key-value form
	 * 
	 * @param map
	 *            Set of key-values to be entered in the MDC
	 */
	public static void add(HashMap<String, String> map) {
		try {
			for (Map.Entry<String, String> entry : map.entrySet())
				MDC.put(entry.getKey(), entry.getValue());
		} catch (Exception e) {
			log.error(InternalLogMessages.ERRORADDINGCONTEXT, e);
		}
	}

	/**
	 * Method to establish the context information in the log traces. It receives a
	 * map entry and put its key and value in the MDC
	 * 
	 * @param keyValue
	 */
	public static void add(Map.Entry<String, String> keyValue) {
		try {
			MDC.put(keyValue.getKey(), keyValue.getValue());
		} catch (Exception e) {
			log.error(InternalLogMessages.ERRORADDINGCONTEXT, e);
		}
	}
}
