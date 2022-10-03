package com.janettecampbell;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principle: ");
        float principle = Float.parseFloat(scanner.nextLine());

        System.out.print("Annual Interest Rate: ");
        float annualRate = Float.parseFloat(scanner.nextLine());

        System.out.print("Period (Years): ");
        float years = scanner.nextFloat();

        float monthlyRate = (annualRate / PERCENT) / MONTHS_IN_YEAR;
        float payments = years * MONTHS_IN_YEAR;
        double mortgage = principle * ((monthlyRate * (Math.pow(1 + monthlyRate,payments))) / (Math.pow(1 + monthlyRate, payments) - 1));
        String mortgageFormatted = currency.format(mortgage);

        System.out.println(mortgageFormatted);



    }
}
