package com.janettecampbell;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float principle = 0;
        float annualRate = 0;
        float years = 0;

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principle ($1K = $1M): ");
            principle = Float.parseFloat(scanner.nextLine());
            if (principle >= 1000 && principle <=1_000_000) {
                break;
            }
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualRate = Float.parseFloat(scanner.nextLine());
            if (annualRate > 0 && annualRate <= 30) {
                break;
            }
            System.out.println("Enter a number greater than 0 and less than or equal to 30.");
        }

        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextFloat();
            if (years > 0 && years <= 30) {
                break;
            }
            System.out.println("Enter a number greater than 1 and less than or equal to 30");
        }

        float monthlyRate = (annualRate / PERCENT) / MONTHS_IN_YEAR;
        float payments = years * MONTHS_IN_YEAR;
        double mortgage = principle * ((monthlyRate * (Math.pow(1 + monthlyRate,payments))) / (Math.pow(1 + monthlyRate, payments) - 1));
        String mortgageFormatted = currency.format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);



    }
}
