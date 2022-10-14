package me.matrixidot.chemcalc.calculate;

import me.matrixidot.chemcalc.CalcMolarMass;
import me.matrixidot.chemcalc.Main;

import java.util.Scanner;

public class CalcGrams2Moles {
    public CalcGrams2Moles() {
        init();
    }
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Element Symbol:");
        String eSymbol = sc.nextLine();
        System.out.println("Grams of " + eSymbol + ":");
        double eGrams = sc.nextDouble();
        double answer = calc(eSymbol, eGrams);
        System.out.println("=== The amount of moles in " + eGrams + "g of " + eSymbol + " is: " + answer + "mol ===");
        Main.choose();
    }
    public double calc(String eSymbol, double eGrams) {
        double eWeight = new CalcMolarMass().parseCompoundAndWeights(eSymbol);
        return eGrams/eWeight;
    }
    public static double calcOther(String eSymbol, double eGrams) {
        double eWeight = new CalcMolarMass().parseCompoundAndWeights(eSymbol);
        return eGrams/eWeight;
    }
}
