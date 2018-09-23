package data;

public class Cassette extends MusicCarriers {

	private static final long serialVersionUID = 1L;

	public Cassette(String performer, String title, String carrier, String publisher, int price) {
		super(performer, title, carrier, publisher, price);

	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(32);
		print.append(super.toString());
		return print.toString();
	}
}
