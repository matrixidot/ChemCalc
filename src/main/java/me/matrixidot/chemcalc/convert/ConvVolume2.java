package me.matrixidot.chemcalc.convert;

import me.matrixidot.chemcalc.Main;
import me.matrixidot.chemcalc.calculate.*;

import java.util.Scanner;

public class ConvVolume2 {
    public ConvVolume2() {
        init();
    }
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to convert grams into?");
        System.out.println("1: Volume -> Particles");
        System.out.println("2: Volume -> Grams");
        System.out.println("3: Back");
        switch (sc.nextLine()) {
            case "1":
                calcVol2Part();
                break;
            case "2":
                calcVol2Gram();
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
    public void calcVol2Part() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Element Symbol:");
        String eSymbol = sc.nextLine();
        System.out.println("Volume of " + eSymbol + ":");
        double eLiters = sc.nextDouble();
        double moles = CalcVolume2Moles.calcOther(eLiters);
        double particles = CalcMoles2Particles.calcOther(eSymbol, moles);
        System.out.println("=== The number of particles in: " + eLiters + "L of: " + eSymbol + " is: " + particles + " ===");
        Main.choose();

    }
    public void calcVol2Gram() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Element Symbol:");
        String eSymbol = sc.nextLine();
        System.out.println("Volume of " + eSymbol + ":");
        double eLiters = sc.nextDouble();
        double moles = CalcVolume2Moles.calcOther(eLiters);
        double grams = CalcMoles2Grams.calcOther(eSymbol, moles);
        System.out.println("=== The number of grams in: " + eLiters + "L of: " + eSymbol + " is: " + grams + "g ===");
        Main.choose();
    }
}
