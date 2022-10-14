package me.matrixidot.chemcalc.calculate;

import me.matrixidot.chemcalc.Main;

import java.util.Scanner;

public class CalcMoles2Particles {
    public CalcMoles2Particles() {
        init();
    }
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Element Symbol:");
        String eSymbol = sc.nextLine();
        System.out.println("Moles of " + eSymbol + ":");
        double eMoles = sc.nextDouble();
        double answer = calc(eSymbol, eMoles);
        System.out.println("=== The amount of particles in " + eMoles + "mol of " + eSymbol + " is: " + answer + " ===");
        Main.choose();
    }
    public double calc(String eSymbol, double eMoles) {
        double partiConst = 6.02E23;
        return eMoles*partiConst;
    }
    public static double calcOther(String eSymbol, double eMoles) {
        double partiConst = 6.02E23;
        return eMoles*partiConst;
    }
}
