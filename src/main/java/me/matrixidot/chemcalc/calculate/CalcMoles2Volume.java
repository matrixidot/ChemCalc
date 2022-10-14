package me.matrixidot.chemcalc.calculate;

import me.matrixidot.chemcalc.Main;

import java.util.Scanner;

public class CalcMoles2Volume {
    public CalcMoles2Volume() {
        init();
    }
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Element Symbol:");
        String eSymbol = sc.nextLine();
        System.out.println("Moles of " + eSymbol + ":");
        double eMoles = sc.nextDouble();
        double answer = calc(eMoles);
        System.out.println("=== The amount of liters in " + eMoles + "mol of " + eSymbol + " is: " + answer + "L ===");
        Main.choose();
    }
    public double calc(double eMoles) {
        return eMoles*22.4;
    }
    public static double calcOther(double eMoles) {
        return eMoles*22.4;
    }
}
