package app;

import java.util.InputMismatchException;
import java.util.Scanner;

import data.Book;
import data.Cassette;
import data.Cd;
import data.Magazine;
import data.Vinyl;
import data.Warehouse;

public class ControlClass {

	private boolean programIsRunning = true;
	private int input = 0;
	private String title = null;
	private String pages = null;
	private String publisher = null;
	private int price = 0;
	private String edition = null;
	private String issn = null;
	private int year = 0;
	private int volume = 0;
	private String author = null;
	private String isbn = null;
	private String performer = null;
	private String size = null;
	private String type = null;
	private Book book = null;
	private Magazine magazine = null;
	private Cd cd = null;
	private Vinyl vinyl = null;
	private Cassette cassette = null;
	private Scanner sc = null;
	private OptionsForMainMenu optionsForMainMenu;
	private OptionsForSpecialActions optionsForSpecialActions;
	private OptionsForPublications optionsForPublications;
	private OptionsForMusicCarriers optionsForMusicCarriers;
	private OptionsForDeletePublications optionsForDeletePublications;
	private OptionsForDeleteMusicCarriers optionsForDeleteMusicCarriers;
	private Warehouse warehouse = new Warehouse();

	public ControlClass() {
		sc = new Scanner(System.in);
	}

	public void controlApp() {
		while (programIsRunning) {
			System.out.println(showMenu());
			handleInput();
			optionsForMainMenu = OptionsForMainMenu.values()[input];

			switch (optionsForMainMenu) {
			case ADD_BOOK: {
				addBookLogic();
				break;
			}
			case ADD_MAGAZINE: {
				addMagazineLogic();
				break;
			}
			case ADD_CD: {
				addCd();
				break;
			}
			case ADD_CASSETTE: {
				addCassette();
				break;
			}
			case ADD_VINYL: {
				addVinyl();
				break;
			}
			case SHOW_PUBLICATION: {
				showPublicationMenuLogic();
				break;
			}
			case SHOW_MUSIC_CARRIER: {
				showMusicCarriersMenuLogic();
				break;
			}
			case SHOW_ALL_PUBLICATIONS: {
				warehouse.getAllPublication();
				break;
			}
			case SHOW_ALL_MUSIC_CARRIERS: {
				warehouse.getAllMusicCarrier();
				break;
			}
			case SHOW_ALL_WAREHOUSE: {
				warehouse.getAllWarehouse();
				break;
			}
			case DELETE_ALL: {
				warehouse.deleteAll();
				break;
			}
			case DELETE_PUBLICATION: {
				deletePublicationMenuLogic();
				break;
			}
			case DELETE_MUSIC_CARRIER: {
				deleteMusicCarriersMenuLogic();
				break;
			}
			case SPECIAL_ACTIONS: {
				specialActionMenuLogic();
				break;
			}
			case EXIT:
				programIsRunning = false;
				closeScanner();
				break;
			}

		}

	}

	private void closeScanner() {
		sc.close();
	}

	private String showMenu() {
		StringBuilder print = new StringBuilder(32);
		for (OptionsForMainMenu o : OptionsForMainMenu.values()) {
			print.append("| " + o + "\n");
		}
		return print.toString();
	}

	private String showSubMenuSpecialActions() {
		StringBuilder print = new StringBuilder(32);
		for (OptionsForSpecialActions o : OptionsForSpecialActions.values()) {
			print.append("| " + o + "\n");
		}
		return print.toString();
	}

	private String showSubMenuShowPublications() {
		StringBuilder print = new StringBuilder(32);
		for (OptionsForPublications o : OptionsForPublications.values()) {
			print.append("| " + o + "\n");
		}
		return print.toString();
	}

	private String showSubMenuShowMusicCarriers() {
		StringBuilder print = new StringBuilder(32);
		for (OptionsForMusicCarriers o : OptionsForMusicCarriers.values()) {
			print.append("| " + o + "\n");
		}
		return print.toString();
	}

	private String deleteSubMenuShowPublications() {
		StringBuilder print = new StringBuilder(32);
		for (OptionsForDeletePublications o : OptionsForDeletePublications.values()) {
			print.append("| " + o + "\n");
		}
		return print.toString();
	}

	private String deleteSubMenuShowMusicCarriers() {
		StringBuilder print = new StringBuilder(32);
		for (OptionsForDeleteMusicCarriers o : OptionsForDeleteMusicCarriers.values()) {
			print.append("| " + o + "\n");
		}
		return print.toString();
	}

	private void logicForPublications() {
		System.out.println("Write title");
		title = sc.nextLine();
		System.out.println("Write number of pages");
		pages = sc.nextLine();
		System.out.println("Write publisher");
		publisher = sc.nextLine();
		System.out.println("Write price");
		price = sc.nextInt();
		sc.nextLine();
	}

	private void logicForMusicCarriers() {
		System.out.println("Write performer");
		performer = sc.nextLine();
		System.out.println("Write title");
		title = sc.nextLine();
		System.out.println("Write publisher");
		publisher = sc.nextLine();
		System.out.println("Write price");
		price = sc.nextInt();
		sc.nextLine();
	}

	private void addBookLogic() {
		try {
			logicForPublications();
			System.out.println("Write name of author");
			author = sc.nextLine();
			System.out.println("Write ISBN");
			isbn = sc.nextLine();
			book = new Book(title, pages, publisher, author, isbn, price);
			warehouse.addBook(book);
		} catch (InputMismatchException e) {
			e.printStackTrace();
			sc.nextLine();
			System.out.println("Wrong type of data, please try again!!!!!!");
		}

	}

	private void addMagazineLogic() {
		try {
			logicForPublications();
			System.out.println("Write edition");
			edition = sc.nextLine();
			System.out.println("Write issn");
			issn = sc.nextLine();
			System.out.println("Write year");
			year = sc.nextInt();
			sc.nextLine();
			System.out.println("Write volume");
			volume = sc.nextInt();
			sc.nextLine();
			magazine = new Magazine(title, pages, publisher, edition, issn, year, volume, price);
			warehouse.addMagazine(magazine);
		} catch (InputMismatchException e) {
			e.printStackTrace();
			sc.nextLine();
			System.out.println("Wrong type of data, please try again!!!!!!");
		}

	}

	private void addCd() {
		try {
			logicForMusicCarriers();
			cd = new Cd(performer, title, publisher, price);
			warehouse.addCd(cd);
		} catch (InputMismatchException e) {
			e.printStackTrace();
			sc.nextLine();
			System.out.println("Wrong type of data, please try again!!!!!!");
		}

	}

	private void addCassette() {
		try {
			logicForMusicCarriers();
			cassette = new Cassette(performer, title, publisher, price);
			warehouse.addCassette(cassette);
		} catch (InputMismatchException e) {
			e.printStackTrace();
			sc.nextLine();
			System.out.println("Wrong type of data, please try again!!!!!!");
		}

	}

	private void addVinyl() {
		try {
			logicForMusicCarriers();
			System.out.println("Write size");
			size = sc.nextLine();
			System.out.println("Write type");
			type = sc.nextLine();
			vinyl = new Vinyl(performer, title, publisher, price, size, type);
			warehouse.addVinyl(vinyl);
		} catch (InputMismatchException e) {
			e.printStackTrace();
			sc.nextLine();
			System.out.println("Wrong type of data, please try again!!!!!!");
		}

	}

	private void specialActionMenuLogic() {
		boolean inside = true;

		while (inside) {
			System.out.println(showSubMenuSpecialActions());
			handleInput();
			optionsForSpecialActions = OptionsForSpecialActions.values()[input];

			switch (optionsForSpecialActions) {
			case CREATE_CSV: {
				warehouse.saveWarehouseCsv();
				break;
			}
			case INSERT_DATA_FROM_WAREHOUSE_TO_DATABASE: {
				warehouse.logicForInsertDataToDataBase();
				break;
			}
			case LOAD_DATA_FROM_DATABASE_TO_WAREHOUSE: {
				warehouse.logicForLoadDataFromDataBase();
				break;
			}
			case BACK: {
				inside = false;
				break;
			}
			}

		}
	}

	private void showPublicationMenuLogic() {
		boolean inside = true;

		while (inside) {
			System.out.println(showSubMenuShowPublications());
			handleInput();
			/*
			 * 
				I need to add an arrayindexoutofboundsexception exception here and in places below !!!!
			 */
			optionsForPublications = OptionsForPublications.values()[input];

			switch (optionsForPublications) {
			case SHOW_BOOK: {
				System.out.println("Please write title of book");
				titleForPublicationsAndMusicCarriers();
				System.out.println(warehouse.getBooks(title));
				break;
			}
			case SHOW_MAGAZINE: {
				System.out.println("Please write title of magazine");
				titleForPublicationsAndMusicCarriers();
				System.out.println(warehouse.getMagazines(title));
				break;
			}
			case BACK: {
				inside = false;
				break;
			}
			}
		}
	}

	private void showMusicCarriersMenuLogic() {
		boolean inside = true;

		while (inside) {
			System.out.println(showSubMenuShowMusicCarriers());
			handleInput();
			optionsForMusicCarriers = OptionsForMusicCarriers.values()[input];

			switch (optionsForMusicCarriers) {
			case SHOW_CD: {
				performerAndTitleForMusicCarriers();
				System.out.println(warehouse.getCds(title, performer));
				break;
			}
			case SHOW_VINYL: {
				performerAndTitleForMusicCarriers();
				System.out.println(warehouse.getVinyls(title, performer));
				break;
			}
			case SHOW_CASSETTE: {
				performerAndTitleForMusicCarriers();
				System.out.println(warehouse.getCassettes(title, performer));
				break;
			}
			case BACK: {
				inside = false;
				break;
			}
			}

		}
	}

	private void deletePublicationMenuLogic() {
		boolean inside = true;

		while (inside) {
			System.out.println(deleteSubMenuShowPublications());
			handleInput();
			optionsForDeletePublications = OptionsForDeletePublications.values()[input];

			switch (optionsForDeletePublications) {
			case DELETE_BOOK: {
				System.out.println("Please write title of book which you want to delete");
				titleForPublicationsAndMusicCarriers();
				warehouse.deleteBook(title);
				break;
			}
			case DELETE_MAGAZINE: {
				System.out.println("Please write title of magazine which you want to delete");
				titleForPublicationsAndMusicCarriers();
				warehouse.deleteMagazine(title);
				break;
			}
			case BACK: {
				inside = false;
				break;
			}
			}

		}
	}

	private void deleteMusicCarriersMenuLogic() {
		boolean inside = true;

		while (inside) {
			System.out.println(deleteSubMenuShowMusicCarriers());
			handleInput();
			optionsForDeleteMusicCarriers = OptionsForDeleteMusicCarriers.values()[input];

			switch (optionsForDeleteMusicCarriers) {
			case DELETE_CD: {
				System.out.println("Please write title of CD which you want to delete");
				titleForPublicationsAndMusicCarriers();
				warehouse.deleteCd(title);
				break;
			}
			case DELETE_VINYL: {
				System.out.println("Please write title of vinyl which you want to delete");
				titleForPublicationsAndMusicCarriers();
				warehouse.deleteVinyl(title);
				break;
			}
			case DELETE_CASSETTE: {
				System.out.println("Please write title of music carrier which you want to delete");
				titleForPublicationsAndMusicCarriers();
				warehouse.deleteCassette(title);
				break;
			}
			case BACK: {
				inside = false;
				break;
			}
			}

		}
	}

	private void handleInput() {
		boolean errors = true;

		while (errors)
			try {
				input = sc.nextInt();
				sc.nextLine();
				errors = false;
			} catch (InputMismatchException e) {
				e.printStackTrace();
				sc.nextLine();
				System.out.println("Wrong command, please try again!!!!!!");
			}
	}

	private void titleForPublicationsAndMusicCarriers() {
		try {
			title = sc.nextLine();
		} catch (InputMismatchException e) {
			e.printStackTrace();
			sc.nextLine();
			System.out.println("Wrong, please try again!!!!!!");
		}
	}

	private void performerAndTitleForMusicCarriers() {
		System.out.println("Please write performer and title");
		try {
			performer = sc.nextLine();
			title = sc.nextLine();
		} catch (InputMismatchException e) {
			e.printStackTrace();
			sc.nextLine();
			System.out.println("Wrong, please try again!!!!!!");
		}
	}
}
