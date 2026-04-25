package com.project.app.app;

import com.project.app.controller.AppController;

public class MainApp {

	public static void main(String[] args) {
		// Create controller and start the application
		AppController controller = new AppController();
		controller.run();
	}
}