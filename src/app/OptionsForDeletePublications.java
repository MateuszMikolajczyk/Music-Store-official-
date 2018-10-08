package app;

public enum OptionsForDeletePublications {
	
	BACK(0,"BACK"),
	DELETE_BOOK(1,"DELETE BOOK"),
	DELETE_MAGAZINE(2,"DELETE MAGAZINE");
	private int value;
	private String description;

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	OptionsForDeletePublications(int value, String description){
		this.value = value;
		this.description = description;
	}
	
	public String toString() {
		return value + "-" + description;
	}
}
