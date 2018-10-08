package data;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cd extends MusicCarrier {

	private static final long serialVersionUID = 1L;

	public Cd() {

	}

	public Cd(String performer, String title, String publisher, int price) {
		super(performer, title, publisher, price);
		setDate(LocalDate.now());
		setTime(LocalTime.now());
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(32);
		print.append(super.toString());
		print.append("| Time and Date of added:");
		print.append(getTime());
		print.append(" ");
		print.append(getDate());
		print.append(" |\n");
		return print.toString();
	}

}