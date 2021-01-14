package com.automation.utilities;

import java.math.BigDecimal;

public class DynamicData {

	public static BigDecimal combineTwoStringAsDecimalNumber(String leftNum, String rightNum) {
		Double decimalNumber = Double.parseDouble(leftNum + "." + rightNum);
		return BigDecimal.valueOf(decimalNumber);
	}

	public static BigDecimal convertStringToBigDecimal(String str) {
		if (str.contains("$") && str.indexOf('$') == 0) {
			str = new String(str.substring(1));
		}
		Double doubleData = Double.parseDouble(str);
		return BigDecimal.valueOf(doubleData);
	}



}
