package app;

public enum OptionsForMainMenu {

	EXIT(0,"EXIT"),
	ADD_BOOK(1,"ADD A BOOK"),
	ADD_MAGAZINE(2,"ADD A MAGAZINE"),
	ADD_CD(3,"ADD A CD"),
	ADD_CASSETTE(4,"ADD A CASSETTE"),
	ADD_VINYL(5,"ADD A VINYL"),
	SHOW_PUBLICATION(6,"SHOW PUBLICATION"),
	SHOW_MUSIC_CARRIER(7,"SHOW MUSIC CARRIER"),
	SHOW_ALL_PUBLICATIONS(8,"SHOW ALL PUBLICATIONS"),
	SHOW_ALL_MUSIC_CARRIERS(9,"SHOW ALL MUSIC CARRIERS"),
	SHOW_ALL_WAREHOUSE(10,"SHOW ALL WAREHOUSE"),
	DELETE_ALL(11,"DELETE ALL"),
	DELETE_PUBLICATION(12,"DELETE PUBLICATION"),
	DELETE_MUSIC_CARRIER(13,"DELETE MUSIC CARRIER"),
	SPECIAL_ACTIONS(14,"SPECIAL ACTIONS");
	private int value;
	private String description;

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	OptionsForMainMenu(int value, String description){
		this.value = value;
		this.description = description;
	}
	
	public String toString() {
		return value + "-" + description;
	}
}
