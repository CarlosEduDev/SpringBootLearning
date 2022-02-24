package br.com.erudio.utils;

public class NumberUtil {

	public static boolean isNumber(String strNumber) {
		if (strNumber == null)
			return false;
		return strNumber.replace(',', '.').matches("[\\d.]+");
	}

	public static boolean isNumber(String... strNumbers) {
		for (String strNumber : strNumbers)
			if (!isNumber(strNumber))
				return false;
		return true;

	}

	public static Double toDouble(String strNumber) {
		if (strNumber == null)
			return 0D;
		return Double.parseDouble(strNumber);
	}

}
