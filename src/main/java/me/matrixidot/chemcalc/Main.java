package me.matrixidot.chemcalc;

import me.matrixidot.chemcalc.calculate.*;
import me.matrixidot.chemcalc.convert.ConvGrams2;
import me.matrixidot.chemcalc.convert.ConvParticles2;
import me.matrixidot.chemcalc.convert.ConvVolume2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        choose();
    }
    public static void choose() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("1: Calculate (Moles <-> Something)");
        System.out.println("2: Convert (Something -> Moles -> Something Else");
        System.out.println("3: Exit");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                choose2();
                break;
            case "2":
                choose3();
                break;
            case "3":
                System.out.println("Exiting ChemCalc... Hope you enjoyed!");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                choose();
                break;
        }
    }

    public static void choose2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to calculate?");
        System.out.println("1: Molar mass of a compound.");
        System.out.println("2: Moles to grams.");
        System.out.println("3: Grams to moles.");
        System.out.println("4: Moles to particles");
        System.out.println("5: Particles to moles");
        System.out.println("6: Volume to moles (@STP)");
        System.out.println("7: Moles to volume (@STP)");
        System.out.println("8: Back");
        System.out.println("9: Exit");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                CalcMolarMass cmm = new CalcMolarMass();
                cmm.init();
                choose();
                break;
            case "2":
                new CalcMoles2Grams();
                break;
            case "3":
                new CalcGrams2Moles();
                break;
            case "4":
                new CalcMoles2Particles();
                break;
            case "5":
                new CalcParticles2Moles();
                break;
            case "6":
                new CalcVolume2Moles();
                break;
            case "7":
                new CalcMoles2Volume();
                break;
            case "8":
                choose();
            case "9":
                System.out.println("Quitting ChemCalc... Hope you enjoyed!");
                break;
            default:
                System.out.println(choice + "Is an invalid choice... Restarting ChemCalc.");
                choose2();
        }
    }
    public static void choose3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to convert?");
        System.out.println("1: Mass Conversions");
        System.out.println("2: Volume Conversions (@STP)");
        System.out.println("3: Particle Conversions");
        System.out.println("4: Back");
        System.out.println("5: Exit");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                new ConvGrams2();
                break;
            case "2":
                new ConvVolume2();
                break;
            case "3":
                new ConvParticles2();
                break;
            case "4":
                choose();
                break;
            case "5":
                System.out.println("Exiting ChemCalc... Hope you enjoyed!");
                break;
            default:
                System.out.println(choice + "Is an invalid choice... Please try again.");
                choose3();
        }
    }
}
