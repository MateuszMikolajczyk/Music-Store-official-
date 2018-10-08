package app;

public enum OptionsForDeleteMusicCarriers {
	
	BACK(0,"BACK"),
	DELETE_CD(1,"DELETE CD"),
	DELETE_VINYL(2,"DELETE VINYL"),
	DELETE_CASSETTE(3,"DELETE CASSETTE");
	private int value;
	private String description;

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	OptionsForDeleteMusicCarriers(int value, String description){
		this.value = value;
		this.description = description;
	}
	
	public String toString() {
		return value + "-" + description;
	}
}
