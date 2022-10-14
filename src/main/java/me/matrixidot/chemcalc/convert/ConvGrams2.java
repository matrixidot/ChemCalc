package me.matrixidot.chemcalc.convert;

import me.matrixidot.chemcalc.Main;
import me.matrixidot.chemcalc.calculate.CalcGrams2Moles;
import me.matrixidot.chemcalc.calculate.CalcMoles2Particles;
import me.matrixidot.chemcalc.calculate.CalcMoles2Volume;

import java.util.Scanner;

public class ConvGrams2 {
    public ConvGrams2() {
        init();
    }
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to convert grams into?");
        System.out.println("1: Grams -> Volume");
        System.out.println("2: Grams -> Particles");
        System.out.println("3: Back");
        switch (sc.nextLine()) {
            case "1":
                calcGrams2Vol();
                break;
            case "2":
                calcGrams2Part();
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
    public void calcGrams2Vol() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Element Symbol:");
        String eSymbol = sc.nextLine();
        System.out.println("Grams of " + eSymbol + ":");
        double eGrams = sc.nextDouble();
        double molesOfCompound = CalcGrams2Moles.calcOther(eSymbol, eGrams);
        double volumeFromMoles = CalcMoles2Volume.calcOther(molesOfCompound);
        System.out.println("=== The number of liters in: " + eGrams + "g of: " + eSymbol + " is: " + volumeFromMoles + "L ===");
        Main.choose();

    }
    public void calcGrams2Part() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Element Symbol:");
        String eSymbol = sc.nextLine();
        System.out.println("Grams of " + eSymbol + ":");
        double eGrams = sc.nextDouble();
        double molesOfCompound = CalcGrams2Moles.calcOther(eSymbol, eGrams);
        double partiFromMoles = CalcMoles2Particles.calcOther(eSymbol, molesOfCompound);
        System.out.println("=== The number of particles in: " + eGrams + "g of: " + eSymbol + " is: " + partiFromMoles + " ===");
        Main.choose();
    }
}
