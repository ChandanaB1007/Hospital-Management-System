package com.example;

/**
 * Hello world!
 *
 */


import java.util.Scanner;

public class HospitalManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Hospital Management System ===");

        // Getting patient details
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Is the patient admitted? (yes/no): ");
        String admissionStatus = scanner.nextLine().trim().toLowerCase();

        System.out.println("\n--- Patient Summary ---");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        if (admissionStatus.equals("yes")) {
            System.out.println("Status: Inpatient");
            System.out.println("Admission Successful !");
        } else {
            System.out.println("Status: Outpatient");
            System.out.println("Visit Recorded Successfully !");
        }

        System.out.println("\nThank you for using the system!");
        scanner.close();
    }
}