package br.com.erudio.utils;

public class MathUtil {
	
	public static Double sum(Double numberOne, Double numberTwo) {
		return numberOne + numberTwo;
	}
	
	public static Double subtraction(Double numberOne, Double numberTwo) {
		return numberOne - numberTwo;
	}

	public static Double multiplication(Double numberOne, Double numberTwo) {
		return numberOne * numberTwo;
	}
	
	public static Double division(Double numberOne, Double numberTwo) {
		return numberOne / numberTwo;
	}
	
	public static Double mean(Double numberOne, Double numberTwo) {
		return (numberOne + numberTwo)/2;
	}
	
	public static Double squareRoot(Double number) {
		return (Double) Math.sqrt(number);
	}
	
	public static Double sum(String strNumberOne, String strNumberTwo) {
		return sum(NumberUtil.toDouble(strNumberOne), NumberUtil.toDouble(strNumberTwo));
	}
	
	public static Double subtraction(String strNumberOne, String strNumberTwo) {
		return subtraction(NumberUtil.toDouble(strNumberOne), NumberUtil.toDouble(strNumberTwo));
	}
	
	public static Double division(String strNumberOne, String strNumberTwo) {
		return division(NumberUtil.toDouble(strNumberOne), NumberUtil.toDouble(strNumberTwo));
	}
	
	public static Double mean(String strNumberOne, String strNumberTwo) {
		return mean(NumberUtil.toDouble(strNumberOne), NumberUtil.toDouble(strNumberTwo));
	}
	
	public static Double squareRoot(String strNumber) {
		return squareRoot(NumberUtil.toDouble(strNumber));
	}

	public static Double multiplication(String numberOne, String numberTwo) {
		return multiplication(NumberUtil.toDouble(numberOne), NumberUtil.toDouble(numberTwo));
	}
	
	
}
