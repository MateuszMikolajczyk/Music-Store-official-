package app;

public enum OptionsForSpecialActions {
	
	BACK(0,"BACK"),
	CREATE_CSV(1,"CREATE CSV FILES"),
	INSERT_DATA_FROM_WAREHOUSE_TO_DATABASE(2,"INSERT DATA FROM WAREHOUSE TO DATABASE"),
	LOAD_DATA_FROM_DATABASE_TO_WAREHOUSE(3,"LOAD DATA FROM DATABASE TO WAREHOUSE");
	private int value;
	private String description;

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	OptionsForSpecialActions(int value, String description){
		this.value = value;
		this.description = description;
	}
	
	public String toString() {
		return value + "-" + description;
	}
}
