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

	private final int addBook = 1;
	private final int addMagazine = 2;
	private final int addCd = 3;
	private final int addCassette = 4;
	private final int addVinyl = 5;
	private final int showPublication = 6;
	private final int showMusicCarrier = 7;
	private final int showlAllPublications = 8;
	private final int showlAllMusicCarriers = 9;
	private final int showlAllWarehouse = 10;
	private final int deleteAll = 11;
	private final int deletePublication = 12;
	private final int deleteMusicCarrier = 13;
	private final int specialActions = 14;
	private final int exit = 15;

	private Scanner sc = null;

	public ControlClass() {
		sc = new Scanner(System.in);
	}

	public void closeScanner(Scanner sc) {
		sc.close();
	}

	private boolean error = true;
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

	private Warehouse warehouse = new Warehouse();
	private Book book = null;
	private Magazine magazine = null;
	private Cd cd = null;
	private Vinyl vinyl = null;
	private Cassette cassette = null;

	public void controlApp() {
		while (error) {
			System.out.println(showMenu());
			exceptionForInput(15);
			switch (input) {
			case addBook: {
				try {
					sameDataForPublications(sc);
					System.out.println("Write name of author");
					author = sc.nextLine();
					System.out.println("Write ISBN");
					isbn = sc.nextLine();
				} catch (InputMismatchException e) {
					e.printStackTrace();
					System.out.println("Wrong type of data, please try again!!!!!!");
					sc.nextLine();
				}
				book = new Book(title, pages, publisher, author, isbn, price);
				warehouse.addBook(book);
				break;
			}
			case addMagazine: {
				try {
					sameDataForPublications(sc);
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
				} catch (InputMismatchException e) {
					e.printStackTrace();
					System.out.println("Wrong type of data, please try again!!!!!!");
					sc.nextLine();
				}
				magazine = new Magazine(title, pages, publisher, edition, issn, year, volume, price);
				warehouse.addMagazine(magazine);
				break;
			}
			case addCd: {
				try {
					sameDataForMusicCarriers(sc);
				} catch (InputMismatchException e) {
					e.printStackTrace();
					System.out.println("Wrong type of data, please try again!!!!!!");
					sc.nextLine();
				}
				cd = new Cd(performer, title, publisher, price);
				warehouse.addCd(cd);
				break;
			}
			case addCassette: {
				try {
					sameDataForMusicCarriers(sc);
				} catch (InputMismatchException e) {
					e.printStackTrace();
					System.out.println("Wrong type of data, please try again!!!!!!");
					sc.nextLine();
				}
				cassette = new Cassette(performer, title, publisher, price);
				warehouse.addCassette(cassette);
				break;
			}
			case addVinyl: {
				try {
					sameDataForMusicCarriers(sc);
					System.out.println("Write size");
					size = sc.nextLine();
					System.out.println("Write type");
					type = sc.nextLine();
				} catch (InputMismatchException e) {
					e.printStackTrace();
					System.out.println("Wrong type of data, please try again!!!!!!");
					sc.nextLine();
				}
				vinyl = new Vinyl(performer, title, publisher, price, size, type);
				warehouse.addVinyl(vinyl);
				break;
			}
			case showPublication: {
				showPublicationMenuLogic();
				break;
			}
			case showMusicCarrier: {
				showMusicCarriersMenuLogic();
				break;
			}
			case showlAllPublications: {
				warehouse.getAllPublication();
				break;
			}
			case showlAllMusicCarriers: {
				warehouse.getAllMusicCarrier();
				break;
			}
			case showlAllWarehouse: {
				warehouse.getAllWarehouse();
				break;
			}
			case deleteAll: {
				warehouse.deleteAll();
				break;
			}
			case deletePublication: {
				deletePublicationMenuLogic();
				break;
			}
			case deleteMusicCarrier: {
				deleteMusicCarriersMenuLogic();
				break;
			}
			case specialActions: {
				specialActionMenuLogic();
				break;
			}
			case exit:
				error = false;
				break;
			}

		}

	}

	public void sameDataForPublications(Scanner sc) {
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

	public void sameDataForMusicCarriers(Scanner sc) {
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

	public String showMenu() {
		StringBuilder print = new StringBuilder(32);
		print.append("| 1 - Add book \n");
		print.append("| 2 - Add magazine \n");
		print.append("| 3 - Add cd \n");
		print.append("| 4 - Add cassette \n");
		print.append("| 5 - Add vinyl \n");
		print.append("| 6 - Show publication \n");
		print.append("| 7 - Show music carrier \n");
		print.append("| 8 - Show all publication \n");
		print.append("| 9 - Show all music carrier \n");
		print.append("| 10 - Show all warehouse \n");
		print.append("| 11 - Delete all \n");
		print.append("| 12 - Delete publication \n");
		print.append("| 13 - Delete music carrier \n");
		print.append("| 14 - Special actions \n");
		print.append("| 15 - EXIT ");
		return print.toString();
	}

	public String showSubMenuSpecialActions() {
		StringBuilder print = new StringBuilder(32);
		print.append("| 1 - Create CSV warehouse\n");
		print.append("| 2 - Back");
		return print.toString();
	}

	public String showSubMenuShowPublications() {
		StringBuilder print = new StringBuilder(32);
		print.append("| 1 - Show book\n");
		print.append("| 2 - Show magazine\n");
		print.append("| 3 - Back");
		return print.toString();
	}

	public String showSubMenuShowMusicCarriers() {
		StringBuilder print = new StringBuilder(32);
		print.append("| 1 - Show CD\n");
		print.append("| 2 - Show vinyl\n");
		print.append("| 3 - Show cassette\n");
		print.append("| 4 - Back");
		return print.toString();
	}

	public String deleteSubMenuShowPublications() {
		StringBuilder print = new StringBuilder(32);
		print.append("| 1 - delete book\n");
		print.append("| 2 - delete magazine\n");
		print.append("| 3 - back");
		return print.toString();
	}

	public String deleteSubMenuShowMusicCarriers() {
		StringBuilder print = new StringBuilder(32);
		print.append("| 1 - delete CD\n");
		print.append("| 2 - delete vinyl\n");
		print.append("| 3 - delete cassette\n");
		print.append("| 4 - back");
		return print.toString();
	}

	public void specialActionMenuLogic() {
		boolean back = true;

		while (back) {
			System.out.println(showSubMenuSpecialActions());
			exceptionForInput(2);
			switch (input) {
			case 1: {
				warehouse.saveWarehouseCsv();
				break;
			}
			case 2: {
				back = false;
				break;
			}
			}

		}
	}

	public void showPublicationMenuLogic() {
		boolean back = true;

		while (back) {
			System.out.println(showSubMenuShowPublications());
			exceptionForInput(3);
			switch (input) {
			case 1: {
				System.out.println("Please write title of book");
				exceptionForPublicationsAndMusicCarriersTitle();
				System.out.println(warehouse.getBook(title));
				break;
			}
			case 2: {
				System.out.println("Please write title of magazine");
				exceptionForPublicationsAndMusicCarriersTitle();
				System.out.println(warehouse.getMagazine(title));
				break;
			}
			case 3: {
				back = false;
				break;
			}
			}
		}
	}

	public void showMusicCarriersMenuLogic() {
		boolean back = true;

		while (back) {
			System.out.println(showSubMenuShowMusicCarriers());
			exceptionForInput(4);
			switch (input) {
			case 1: {
				exceptionForMusicCarriersPerformerAndTitle();
				System.out.println(warehouse.getCd(title, performer));
				break;
			}
			case 2: {
				exceptionForMusicCarriersPerformerAndTitle();
				System.out.println(warehouse.getVinyl(title, performer));
				break;
			}
			case 3: {
				exceptionForMusicCarriersPerformerAndTitle();
				System.out.println(warehouse.getCassette(title, performer));
				break;
			}
			case 4: {
				back = false;
				break;
			}
			}

		}
	}

	public void deletePublicationMenuLogic() {
		boolean back = true;

		while (back) {
			System.out.println(deleteSubMenuShowPublications());
			exceptionForInput(3);
			switch (input) {
			case 1: {
				System.out.println("Please write title of book which you want to delete");
				exceptionForPublicationsAndMusicCarriersTitle();
				warehouse.deleteBook(title);
				break;
			}
			case 2: {
				System.out.println("Please write title of magazine which you want to delete");
				exceptionForPublicationsAndMusicCarriersTitle();
				warehouse.deleteMagazine(title);
				break;
			}
			case 3: {
				back = false;
				break;
			}
			}

		}
	}

	public void deleteMusicCarriersMenuLogic() {
		boolean back = true;

		while (back) {
			System.out.println(deleteSubMenuShowMusicCarriers());
			exceptionForInput(4);
			switch (input) {
			case 1: {
				System.out.println("Please write title of CD which you want to delete");
				exceptionForPublicationsAndMusicCarriersTitle();
				warehouse.deleteCd(title);
				break;
			}
			case 2: {
				System.out.println("Please write title of vinyl which you want to delete");
				exceptionForPublicationsAndMusicCarriersTitle();
				warehouse.deleteVinyl(title);
				break;
			}
			case 3: {
				System.out.println("Please write title of music carrier which you want to delete");
				exceptionForPublicationsAndMusicCarriersTitle();
				warehouse.deleteCassette(title);
				break;
			}
			case 4: {
				back = false;
				break;
			}
			}

		}
	}

	public void exceptionForInput(int maxChoice) {
		try {
			input = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			e.printStackTrace();
			sc.nextLine();
		}
		if (input > maxChoice || input <= 0) {
			System.out.println("Wrong command, please try again!!!!!!");
		}
	}

	public void exceptionForPublicationsAndMusicCarriersTitle() {
		try {
			title = sc.nextLine();
		} catch (InputMismatchException e) {
			e.printStackTrace();
			System.out.println("Wrong, please try again!!!!!!");
			sc.nextLine();
		}
	}

	public void exceptionForMusicCarriersPerformerAndTitle() {
		System.out.println("Please write performer and title");
		try {
			performer = sc.nextLine();
			title = sc.nextLine();
		} catch (InputMismatchException e) {
			e.printStackTrace();
			System.out.println("Wrong, please try again!!!!!!");
			sc.nextLine();
		}
	}
}
