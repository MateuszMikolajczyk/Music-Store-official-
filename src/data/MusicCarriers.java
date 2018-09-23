package data;

import java.io.Serializable;

public class MusicCarriers implements Serializable {

	private static final long serialVersionUID = 1L;
	private String performer;
	private String title;
	private String carrier;
	private String publisher;
	private int price;

	public String getPerformer() {
		return performer;
	}

	public void setPerformer(String performer) {
		this.performer = performer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public MusicCarriers() {

	}

	public MusicCarriers(String performer, String title, String carrier, String publisher, int price) {
		this.performer = performer;
		this.title = title;
		this.carrier = carrier;
		this.publisher = publisher;
		this.price = price;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrier == null) ? 0 : carrier.hashCode());
		result = prime * result + ((performer == null) ? 0 : performer.hashCode());
		result = prime * result + price;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MusicCarriers other = (MusicCarriers) obj;
		if (carrier == null) {
			if (other.carrier != null)
				return false;
		} else if (!carrier.equals(other.carrier))
			return false;
		if (performer == null) {
			if (other.performer != null)
				return false;
		} else if (!performer.equals(other.performer))
			return false;
		if (price != other.price)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
