package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Patient {
    String patientId;
    String name;
    int age;
    boolean isAdmitted;

    Patient(String patientId, String name, int age, boolean isAdmitted) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.isAdmitted = isAdmitted;
    }

    void displayInfo() {
        System.out.println("\n--- Patient Details ---");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Status: " + (isAdmitted ? "Inpatient" : "Outpatient"));
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Patient> patientDatabase = new HashMap<>();

        System.out.println("=== Welcome to Hospital Management System ===");

        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add New Patient");
            System.out.println("2. View Existing Patient");
            System.out.println("3. Exit");

            System.out.print("Enter your choice (1-3): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
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
                    boolean isAdmitted = admissionStatus.equals("yes");

                    // Store patient in the database
                    Patient newPatient = new Patient(patientId, name, age, isAdmitted);
                    patientDatabase.put(patientId, newPatient);

                    // Show confirmation
                    System.out.println("\n--- Patient Summary ---");
                    newPatient.displayInfo();
                    System.out.println(isAdmitted ? "Admission Successful!" : "Visit Recorded Successfully!");
                    break;

                case "2":
                    System.out.print("Enter Patient ID to search: ");
                    String searchId = scanner.nextLine();
                    Patient existingPatient = patientDatabase.get(searchId);

                    if (existingPatient != null) {
                        existingPatient.displayInfo();
                    } else {
                        System.out.println("Patient with ID " + searchId + " not found.");
                    }
                    break;

                case "3":
                    System.out.println("Exiting... Thank you for using the system!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select 1, 2 or 3.");
            }
        }
    }
}