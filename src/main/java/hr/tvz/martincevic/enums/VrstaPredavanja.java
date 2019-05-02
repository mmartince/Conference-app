package hr.tvz.martincevic.enums;

import java.util.ResourceBundle;

public enum VrstaPredavanja
{
	RADIONICA, PREZENTACIJA;

	private static final ResourceBundle res = ResourceBundle.getBundle("i18n/messages");

	public String getText()
	{
		return res.getString(name() + ".string");
	}
}
