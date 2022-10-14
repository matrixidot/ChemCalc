package me.matrixidot.chemcalc.calculate;

import me.matrixidot.chemcalc.CalcMolarMass;
import me.matrixidot.chemcalc.Main;

import java.util.Scanner;

public class CalcMoles2Grams {
    public CalcMoles2Grams() {
        init();
    }
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Element Symbol:");
        String eSymbol = sc.nextLine();
        System.out.println("Moles of " + eSymbol + ":");
        double eMoles = sc.nextDouble();
        double answer = calc(eSymbol, eMoles);
        System.out.println("=== The amount of grams in " + eMoles + "mol of " + eSymbol + " is: " + answer + "g ===");
        Main.choose();
    }
    public double calc(String eSymbol, double eMoles) {
        double eWeight = new CalcMolarMass().parseCompoundAndWeights(eSymbol);
        return eMoles*eWeight;
    }
    public static double calcOther(String eSymbol, double eMoles) {
        double eWeight = new CalcMolarMass().parseCompoundAndWeights(eSymbol);
        return eMoles*eWeight;
    }
}
