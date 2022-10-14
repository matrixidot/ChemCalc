package me.matrixidot.chemcalc.convert;

import me.matrixidot.chemcalc.Main;
import me.matrixidot.chemcalc.calculate.*;

import java.util.Scanner;

public class ConvParticles2 {
    public ConvParticles2() {
        init();
    }
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to convert grams into?");
        System.out.println("1: Particles -> Volume");
        System.out.println("2: Particles -> Grams");
        System.out.println("3: Back");
        switch (sc.nextLine()) {
            case "1":
                calcPart2Vol();
                break;
            case "2":
                calcPart2Grams();
                break;
            case "3":
                Main.choose3();
                break;
            default:
                System.out.println("Invalid option... Please try again.");
                init();
                break;
        }
    }
    public void calcPart2Vol() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Element Symbol:");
        String eSymbol = sc.nextLine();
        System.out.println("Particles of " + eSymbol + ":");
        double eParticles = sc.nextDouble();
        double moles = CalcParticles2Moles.calcOther(eSymbol, eParticles);
        double volume = CalcMoles2Volume.calcOther(moles);
        System.out.println("=== The number of liters in: " + eParticles + " particles of: " + eSymbol + " is: " + volume + "L ===");
        Main.choose();

    }
    public void calcPart2Grams() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Element Symbol:");
        String eSymbol = sc.nextLine();
        System.out.println("Particles of " + eSymbol + ":");
        double eParticles = sc.nextDouble();
        double moles = CalcParticles2Moles.calcOther(eSymbol, eParticles);
        double grams = CalcMoles2Grams.calcOther(eSymbol, moles);
        System.out.println("=== The number of grams in: " + eParticles + " particles of: " + eSymbol + " is: " + grams + "g ===");
        Main.choose();
    }
}
