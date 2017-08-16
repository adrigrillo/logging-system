package com.example.logging;

import ch.qos.cal10n.BaseName;
import ch.qos.cal10n.Locale;
import ch.qos.cal10n.LocaleData;

@BaseName("internallogmessages")
@LocaleData(defaultCharset = "UTF8", value = { @Locale("es"), @Locale("en") })
public enum InternalLogMessages {
	ERRORREADINGPROPFILE, ERRORREADINGPROP, ERRORADDINGCONTEXT, INVALIDINTRODUCEDLOCALE, LOCALEREADOK, COUNTRYNOTFOUND, LANGUAGENOTFOUND;
}
