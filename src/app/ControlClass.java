package app;

import java.util.InputMismatchException;
import java.util.Scanner;

import data.Book;
import data.Cassette;
import data.Cd;
import data.Magazine;
import data.MusicCarriers;
import data.Publications;
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
	private String carrier = null;
	private String size = null;
	private String type = null;

	private Warehouse warehouse = new Warehouse();
	private Publications publications = null;
	private MusicCarriers musicCarriers = null;

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
				publications = new Book(title, pages, publisher, author, isbn, price);
				warehouse.addPublications(publications);
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
				publications = new Magazine(title, pages, publisher, edition, issn, year, volume, price);
				warehouse.addPublications(publications);
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
				musicCarriers = new Cd(performer, title, carrier, publisher, price);
				warehouse.addMusicCarriers(musicCarriers);
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
				musicCarriers = new Cassette(performer, title, carrier, publisher, price);
				warehouse.addMusicCarriers(musicCarriers);
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
				musicCarriers = new Vinyl(performer, title, carrier, publisher, price, size, type);
				warehouse.addMusicCarriers(musicCarriers);
				break;
			}
			case showPublication: {
				System.out.println("Please write title of publication");
				try {
					title = sc.nextLine();
				} catch (InputMismatchException e) {
					e.printStackTrace();
					System.out.println("Wrong, please try again!!!!!!");
					sc.nextLine();
				}
				System.out.println(warehouse.getPublication(title));
				break;
			}
			case showMusicCarrier: {
				System.out.println("Please write performer and title");
				try {
					performer = sc.nextLine();
					title = sc.nextLine();
				} catch (InputMismatchException e) {
					e.printStackTrace();
					System.out.println("Wrong, please try again!!!!!!");
					sc.nextLine();
				}
				System.out.println(warehouse.getMusicCarrier(title, performer));
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
				System.out.println("Please write title of publication which you want to delete");
				try {
					title = sc.nextLine();
				} catch (InputMismatchException e) {
					e.printStackTrace();
					System.out.println("Wrong, please try again!!!!!!");
					sc.nextLine();
				}
				warehouse.deletePublication(title);
				break;
			}
			case deleteMusicCarrier: {
				System.out.println("Please write title of music carrier which you want to delete");
				try {
					title = sc.nextLine();
				} catch (InputMismatchException e) {
					e.printStackTrace();
					System.out.println("Wrong, please try again!!!!!!");
					sc.nextLine();
				}
				warehouse.deleteMusicCarrier(title);
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
		System.out.println("Write kind of carrier");
		carrier = sc.nextLine();
		System.out.println("Write publisher");
		publisher = sc.nextLine();
		System.out.println("Write price");
		price = sc.nextInt();
		sc.nextLine();
	}

	public String showMenu() {
		StringBuilder print = new StringBuilder(32);
		print.append("| 1 - Add Book \n");
		print.append("| 2 - Add Magazine \n");
		print.append("| 3 - Add Cd \n");
		print.append("| 4 - Add Cassette \n");
		print.append("| 5 - Add Vinyl \n");
		print.append("| 6 - Show Publication \n");
		print.append("| 7 - Show Music Carrier \n");
		print.append("| 8 - Show All Publication \n");
		print.append("| 9 - Show All Music Carrier \n");
		print.append("| 10 - Show All Warehouse \n");
		print.append("| 11 - Delete All \n");
		print.append("| 12 - Delete Publication \n");
		print.append("| 13 - Delete Music Carrier \n");
		print.append("| 14 - Special Actions \n");
		print.append("| 15 - EXIT ");
		return print.toString();
	}

	public String showSubMenu() {
		StringBuilder print = new StringBuilder(32);
		print.append("| 1 - Create CSV Publications (Title,Price,Pages,Publisher)\n");
		print.append("| 2 - Create CSV Music Carriers (Performer,Title,Price,Carrier,Publisher)\n");
		print.append("| 3 - Back");
		return print.toString();
	}

	public void specialActionMenuLogic() {
		boolean back = true;

		while (back) {
			System.out.println(showSubMenu());
			exceptionForInput(3);
			switch (input) {
			case 1: {
				warehouse.savePublicationCsv();
				break;
			}
			case 2: {
				warehouse.saveMusicCarriersCsv();
				break;
			}
			case 3: {
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
}
