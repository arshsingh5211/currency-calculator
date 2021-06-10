package com.techelevatorPractice.CurrencyConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CurrencyConverter {

	public static void main(String[] args) {
		String[] regionArr = new String[] {"USD", "CAD", "INR", "AUD", "EUR"};
		BigDecimal[] ratioArr = new BigDecimal[] {new BigDecimal(1.00), new BigDecimal(1.2600), new BigDecimal(73.154), new BigDecimal(1.313), new BigDecimal(0.8520)};
		// these are the official currency rates current as of 03/31/2021 per US Dept of Treasury website

		Scanner console = new Scanner(System.in);
		int begCurrency = 0;
		int endCurrency = 0;
		boolean run = true;
		while (run) {
			System.out.print("Please select the number corresponding to your choice: ");
			System.out.println("\n\n1. U.S. Dollar\t\t\t\t2. Canadian Dollar");
			System.out.println("3. Indian Rupee\t\t\t\t4. Australian Dollar ");
			System.out.println("5. Euro");
			System.out.print("\nWhat currency would you like to start with? ");
			begCurrency = console.nextInt();
			if (begCurrency < 1 || begCurrency > 5) {
				System.err.println("\nSorry, that is not a valid choice! Please enter a number between 1-5.");
			}
			else run = false;
		}
		run = true;
		while (run) {
			System.out.print("What currency would you like to convert to? ");
			endCurrency = console.nextInt();
			if (endCurrency < 1 || endCurrency > 5) {
				System.err.println("\nSorry, that is not a valid choice! Please enter a number between 1-5.");
			}
			else run = false;
		}
		System.out.print("\nWhat amount would you like converted? Please enter numbers only (no dollar signs or other symbols): ");
		BigDecimal amount = console.nextBigDecimal().setScale(2, RoundingMode.HALF_UP);
		BigDecimal convertedAmt = ratioArr[endCurrency-1].divide(ratioArr[begCurrency-1], 15, RoundingMode.HALF_UP).multiply(amount).setScale(2, RoundingMode.HALF_UP);
		 //amount * endCurrency / begCurrency
		//BigDecimal convertedAmt = amount.multiply(ratioArr[endCurrency-1]).divide(ratioArr[begCurrency-1]).setScale(2, RoundingMode.HALF_UP);
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("\n" + String.format("%,.2f", amount) + " in " + regionArr[begCurrency-1] + " is " + 
				String.format("%,.2f", convertedAmt) + " in " + regionArr[endCurrency-1]);
	}

}