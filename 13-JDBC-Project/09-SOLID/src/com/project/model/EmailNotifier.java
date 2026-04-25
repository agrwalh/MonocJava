package com.project.model;

public class EmailNotifier implements Notifier {

	public void sendNotification(Product product) {
		System.out.println("[EMAIL] Low stock alert for '" + product.getName() + "'");
	}
}