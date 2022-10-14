package me.matrixidot.chemcalc.calculate;

import me.matrixidot.chemcalc.Main;

import java.util.Scanner;

public class CalcVolume2Moles {
    public CalcVolume2Moles() {
        init();
    }
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Element Symbol:");
        String eSymbol = sc.nextLine();
        System.out.println("Liters of " + eSymbol + ":");
        double eLiters = sc.nextDouble();
        double answer = calc(eLiters);
        System.out.println("=== The amount of moles in " + eLiters + "mol of " + eSymbol + " is: " + answer + "mol ===");
        Main.choose();
    }
    public double calc(double eLiters) {
        return eLiters/22.4;
    }
    public static double calcOther(double eLiters) {
        return eLiters/22.4;
    }
}
