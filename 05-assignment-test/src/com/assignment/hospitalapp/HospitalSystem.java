package com.assignment.hospitalapp;

import java.util.Scanner;

public class HospitalSystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		HospitalService[] services = new HospitalService[3];

		int count = 0;

		while (count < services.length) {

			try {

				System.out.println("\nSelect Service Type");
				System.out.println("1. General Consultation");
				System.out.println("2. Surgery");
				System.out.println("3. Diagnostic Test");

				int choice = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Service ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Patient Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Consultation Fee: ");
				double fee = sc.nextDouble();

				switch (choice) {

				case 1:

					services[count] = new GeneralConsultation(id, name, fee);
					break;

				case 2:

					System.out.print("Enter Surgery Charges: ");
					double surgeryCharge = sc.nextDouble();

					services[count] = new Surgery(id, name, fee, surgeryCharge);
					break;

				case 3:

					System.out.print("Enter Test Cost: ");
					double testCost = sc.nextDouble();

					services[count] = new DiagnosticTest(id, name, fee, testCost);
					break;

				default:

					System.out.println("Invalid service type. Try again.");
					continue;
				}

				count++;

			} catch (InvalidServiceException e) {

				System.out.println("Invalid Data: " + e.getMessage());

			} catch (Exception e) {

				System.out.println("Invalid input type. Please enter correct values.");
				sc.nextLine();
			}
		}

		System.out.println("\n----- Processing Services -----");

		for (HospitalService service : services) {

			service.displayService();

			if (service.validateService()) {

				System.out.println("Service Validated Successfully");
				System.out.println("Total Fee: " + service.calculateFee());

			} else {

				System.out.println("Service validation failed");
			}

			System.out.println("------------------------");
		}

		sc.close();
	}
}