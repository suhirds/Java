package com.vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total number of employees: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<Employee> employees = new ArrayList<>();
        

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");
            System.out.print("Employee ID: ");
            int empId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Employee Name: ");
            String empName = scanner.nextLine();
            System.out.print("Grade (U1,U2,U3,U4,P1,P2): ");
            String grade = scanner.nextLine();

            try {
                if (!isValidGrade(grade)) {
                    throw new InvalidGradeException("Invalid grade entered: " + grade);
                }
                employees.add(new Employee(empId, empName, grade));
            } catch (InvalidGradeException e) {
                System.out.println("Error: " + e.getMessage());
                i--; // Decrement i to re-enter details for this employee
            }
        }

        // Write the array of objects into a file
        try (PrintWriter writer = new PrintWriter(new FileWriter("empdetails.txt"))) {
            for (Employee employee : employees) {
                writer.println(employee.getEmpId() + "|" + employee.getEmpName() + "|" + employee.getGrade());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Read the array of objects from the file and display the information to the console
        try (BufferedReader reader = new BufferedReader(new FileReader("empdetails.txt"))) {
            String line;
            System.out.println("\nEmployee details read from file:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int empId = Integer.parseInt(parts[0]);
                String empName = parts[1];
                String grade = parts[2];
                System.out.println(new Employee(empId, empName, grade));
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    private static boolean isValidGrade(String grade) {
        String[] validGrades = {"U1", "U2", "U3", "U4", "P1", "P2"};
        for (String validGrade : validGrades) {
            if (grade.equals(validGrade)) {
                return true;
            }
        }
        return false;
    }
}

