package main;

import app.ControlClass;

public class Main {

	public static final String PROGRAM_NAME_AND_VERSION = "Music Store ver. 2.1.1";

	public static void main(String[] args) {
		System.out.println(PROGRAM_NAME_AND_VERSION + "\n" + "---------------------------");
		ControlClass control = new ControlClass();
		control.controlApp();
	}

}
