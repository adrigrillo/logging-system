package com.example.logging.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.example.logging.InternalLogMessages;

import ch.qos.cal10n.verifier.Cal10nError;
import ch.qos.cal10n.verifier.IMessageKeyVerifier;
import ch.qos.cal10n.verifier.MessageKeyVerifier;


public class LocationTest {

	/**
	 * Test with the languages used in the logging system. There does not have to be
	 * any error, the errorList size has to be 0
	 */
	@Test
	public void goodLocale() {
		IMessageKeyVerifier mkv = new MessageKeyVerifier(InternalLogMessages.class);
		List<Cal10nError> errorList = mkv.verifyAllLocales();
		assertEquals(0, errorList.size());
	}
}
