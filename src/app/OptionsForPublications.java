package app;

public enum OptionsForPublications {
	
	BACK(0,"BACK"),
	SHOW_BOOK(1,"SHOW BOOK"),
	SHOW_MAGAZINE(2,"SHOW MAGAZINE");
	private int value;
	private String description;

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	OptionsForPublications(int value, String description){
		this.value = value;
		this.description = description;
	}
	
	public String toString() {
		return value + "-" + description;
	}
}
