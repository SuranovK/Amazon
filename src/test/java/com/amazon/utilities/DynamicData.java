package com.amazon.utilities;

import java.math.BigDecimal;

public class DynamicData {
	public static BigDecimal returnAsDecimal(String leftNum, String rightNum) {
		
		Double decimalNumber = Double.parseDouble(leftNum + "." + rightNum);
		
		return BigDecimal.valueOf(decimalNumber);
	}

	public static void main(String[] args) {
		System.out.println(DynamicData.returnAsDecimal("34", "99"));
	}

}
