package data;

public class Magazine extends Publications {

	private static final long serialVersionUID = 1L;
	private String edition;
	private String issn;
	private int year;
	private int volume;

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Magazine(String title, String pages, String publisher, String edition, String issn, int year, int volume,
			int price) {
		super(title, pages, publisher, price);
		this.edition = edition;
		this.issn = issn;
		this.year = year;
		this.volume = volume;
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(32);
		print.append(super.toString());
		print.append("| Edition:");
		print.append(getEdition());
		print.append("| ISSN:");
		print.append(getIssn());
		print.append("| Year:");
		print.append(getYear());
		print.append("| Volume");
		print.append(getVolume());
		print.append("| \n");
		return print.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((edition == null) ? 0 : edition.hashCode());
		result = prime * result + ((issn == null) ? 0 : issn.hashCode());
		result = prime * result + volume;
		result = prime * result + year;
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
		Magazine other = (Magazine) obj;
		if (edition == null) {
			if (other.edition != null)
				return false;
		} else if (!edition.equals(other.edition))
			return false;
		if (issn == null) {
			if (other.issn != null)
				return false;
		} else if (!issn.equals(other.issn))
			return false;
		if (volume != other.volume)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
