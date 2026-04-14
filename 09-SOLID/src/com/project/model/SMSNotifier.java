package com.project.model;

public class SMSNotifier implements Notifier {

	public void sendNotification(Product product) {
		System.out.println("[SMS] Low stock alert for '" + product.getName() + "'");
	}
}