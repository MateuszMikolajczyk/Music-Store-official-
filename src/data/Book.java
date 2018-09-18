package data;

public class Book extends Publications {

	private static final long serialVersionUID = 1L;
	private String author;
	private String isbn;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Book(String title, String pages, String publisher, String author, String isbn, int price) {
		super(title, pages, publisher, price);
		this.author = author;
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(32);
		print.append("| Title:");
		print.append(getTitle());
		print.append("| Price:");
		print.append(getPrice());
		print.append("| Pages:");
		print.append(getPages());
		print.append("| Publisher:");
		print.append(getPublisher());
		print.append("| Author:");
		print.append(getAuthor());
		print.append("| ISBN:");
		print.append(getIsbn());
		print.append("| \n");
		return print.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

}
