package me.matrixidot.chemcalc.calculate;

import me.matrixidot.chemcalc.Main;

import java.util.Scanner;

public class CalcParticles2Moles {
    public CalcParticles2Moles() {
        init();
    }
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Element Symbol:");
        String eSymbol = sc.nextLine();
        System.out.println("Particles of " + eSymbol + ":");
        double eParticles = sc.nextDouble();
        double answer = calc(eSymbol, eParticles);
        System.out.println("=== The number of moles in " + eParticles + " particles of " + eSymbol + " is: " + answer + "mol ===");
        Main.choose();
    }
    public double calc(String eSymbol, double eParticles) {
        double partiConst = 6.02E23;
        return eParticles/partiConst;
    }
    public static double calcOther(String eSymbol, double eParticles) {
        double partiConst = 6.02E23;
        return eParticles/partiConst;
    }
}
