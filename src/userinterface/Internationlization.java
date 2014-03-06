package userinterface;

import java.util.Locale;
import java.util.ResourceBundle;

public class Internationlization {
	private static String language = "en";
	private static String country = "US";

	private static Locale currentLocale;
	private static ResourceBundle messages;

	public Internationlization() {

		currentLocale = new Locale(language, country);

		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
	}

	public ResourceBundle getInternationlizationBundle() {

		return messages;

	}

	public void setLanguage(String lang) {
		language = lang;

	}

	public void setCountry(String count) {
		country = count;

	}
}
