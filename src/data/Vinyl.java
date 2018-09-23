package data;

public class Vinyl extends MusicCarriers {

	private static final long serialVersionUID = 1L;
	private String size;
	private String type;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Vinyl(String performer, String title, String carrier, String publisher, int price, String size,
			String type) {
		super(performer, title, carrier, publisher, price);
		this.size = size;
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(32);
		print.append(super.toString());
		print.append("| Size:");
		print.append(getSize());
		print.append("| Type:");
		print.append(getType());
		print.append("| \n");
		return print.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vinyl other = (Vinyl) obj;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
