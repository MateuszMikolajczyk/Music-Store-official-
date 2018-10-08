package app;

public enum OptionsForMusicCarriers {
	
	BACK(0,"BACK"),
	SHOW_CD(1,"SHOW CD"),
	SHOW_VINYL(2,"SHOW VINYL"),
	SHOW_CASSETTE(3,"SHOW CASSETTE");
	private int value;
	private String description;

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	OptionsForMusicCarriers(int value, String description){
		this.value = value;
		this.description = description;
	}
	
	public String toString() {
		return value + "-" + description;
	}
}
