package com.project.test;

import java.util.Scanner;
import com.project.model.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Notifier[] notifiers = { new EmailNotifier(), new SMSNotifier() };

		InventoryService service = new InventoryService(notifiers, new ReorderService());

	
		InventoryApp app = new InventoryApp(service, sc);
		app.start();
	}
}