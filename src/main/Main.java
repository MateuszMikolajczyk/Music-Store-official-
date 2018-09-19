package main;

import app.ControlClass;

public class Main {

	public static final String PROGRAME_NAME_AND_VERSION = "Music Store ver. 1.0";

	public static void main(String[] args) {
		System.out.println(PROGRAME_NAME_AND_VERSION + "\n" + "---------------------------");
		ControlClass control = new ControlClass();
		control.controlApp();
		System.out.println("test branch");
	}

}
