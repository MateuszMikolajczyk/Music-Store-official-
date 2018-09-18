package data;

public class Cd extends MusicCarriers {

	private static final long serialVersionUID = 1L;

	public Cd(String performer, String title, String carrier, String publisher, int price) {
		super(performer, title, carrier, publisher, price);

	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(32);
		print.append("| Performer:");
		print.append(getPerformer());
		print.append("| Title:");
		print.append(getTitle());
		print.append("| Price:");
		print.append(getPrice());
		print.append("| Carrier:");
		print.append(getCarrier());
		print.append("| Publisher:");
		print.append(getPublisher());
		print.append("| \n");
		return print.toString();
	}

}