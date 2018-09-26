package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import additionalFunctions.CsvTools;

public class Warehouse {

	private HashMap<String, Book> book;
	private HashMap<String, Magazine> magazine;
	private HashMap<String, Cd> cd;
	private HashMap<String, Vinyl> vinyl;
	private HashMap<String, Cassette> cassette;
	private MyDatabase myDataBase = new MyDatabase();

	public Warehouse() {
		book = new HashMap<>();
		magazine = new HashMap<>();
		cd = new HashMap<>();
		vinyl = new HashMap<>();
		cassette = new HashMap<>();
		loadDataFromMyDatabase();
	}

	public void loadDataFromMyDatabase() {
		Path pathBooks = Paths.get(MyDatabase.MY_DATABASE_BOOKS_FILE_NAME);
		Path pathMagazines = Paths.get(MyDatabase.MY_DATABASE_MAGAZINES_FILE_NAME);
		Path pathCd = Paths.get(MyDatabase.MY_DATABASE_CDS_FILE_NAME);
		Path pathVinyls = Paths.get(MyDatabase.MY_DATABASE_VINYLS_FILE_NAME);
		Path pathCassettes = Paths.get(MyDatabase.MY_DATABASE_CASSETTES_FILE_NAME);
		if (Files.exists(pathBooks)) {
			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(MyDatabase.MY_DATABASE_BOOKS_FILE_NAME));) {

				book = (HashMap<String, Book>) ois.readObject();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (Files.exists(pathMagazines)) {
			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(MyDatabase.MY_DATABASE_MAGAZINES_FILE_NAME));) {

				magazine = (HashMap<String, Magazine>) ois.readObject();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (Files.exists(pathCd)) {
			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(MyDatabase.MY_DATABASE_CDS_FILE_NAME));) {

				cd = (HashMap<String, Cd>) ois.readObject();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (Files.exists(pathVinyls)) {
			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(MyDatabase.MY_DATABASE_VINYLS_FILE_NAME));) {

				vinyl = (HashMap<String, Vinyl>) ois.readObject();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (Files.exists(pathCassettes)) {
			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(MyDatabase.MY_DATABASE_CASSETTES_FILE_NAME));) {

				cassette = (HashMap<String, Cassette>) ois.readObject();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean addBook(Book book) {
		String bookKey = book.getTitle();

		if (this.book.get(bookKey) != null) {
			System.out.println("This publication already exists");
			return false;
		} else {
			this.book.put(bookKey, book);
			myDataBase.saveBook(this.book);
			return true;
		}
	}

	public boolean addMagazine(Magazine magazine) {
		String magazineKey = magazine.getTitle();

		if (this.magazine.get(magazineKey) != null) {
			System.out.println("This publication already exists");
			return false;
		} else {
			this.magazine.put(magazineKey, magazine);
			myDataBase.saveMagazine(this.magazine);
			return true;
		}
	}

	public boolean addCd(Cd cd) {
		String cdKey = cd.getPerformer() + " " + cd.getTitle();

		if (this.cd.get(cdKey) != null) {
			System.out.println("This music carrier already exists");
			return false;
		} else {
			this.cd.put(cdKey, cd);
			myDataBase.saveCd(this.cd);
			return true;
		}
	}

	public boolean addVinyl(Vinyl vinyl) {
		String vinylKey = vinyl.getPerformer() + " " + vinyl.getTitle();

		if (this.vinyl.get(vinylKey) != null) {
			System.out.println("This music carrier already exists");
			return false;
		} else {
			this.vinyl.put(vinylKey, vinyl);
			myDataBase.saveVinyl(this.vinyl);
			return true;
		}
	}

	public boolean addCassette(Cassette cassette) {
		String cassetteKey = cassette.getPerformer() + " " + cassette.getTitle();

		if (this.cassette.get(cassetteKey) != null) {
			System.out.println("This music carrier already exists");
			return false;
		} else {
			this.cassette.put(cassetteKey, cassette);
			myDataBase.saveCassettes(this.cassette);
			return true;
		}
	}

	public Book getBook(String title) {
		return book.get(title);
	}

	public Magazine getMagazine(String title) {
		return magazine.get(title);
	}

	public Cd getCd(String title, String performer) {
		String performerPlusTitle = performer + " " + title;
		return cd.get(performerPlusTitle);
	}

	public Vinyl getVinyl(String title, String performer) {
		String performerPlusTitle = performer + " " + title;
		return vinyl.get(performerPlusTitle);
	}

	public Cassette getCassette(String title, String performer) {
		String performerPlusTitle = performer + " " + title;
		return cassette.get(performerPlusTitle);
	}

	public void getAllPublication() {
		System.out.println("PUBLICATIONS\n" + "---------------------\n" + "BOOKS\n" + book.values() + "\nMAGAZINES\n"
				+ magazine.values() + "\n");
	}

	public void getAllMusicCarrier() {
		System.out.println("MUSIC CARRIERS\n" + "---------------------\n" + "CDs\n" + cd.values() + "\nVINYLS\n"
				+ vinyl.values() + "\nCASSETTES\n" + cassette.values() + "\n");
	}

	public void getAllWarehouse() {
		getAllPublication();
		getAllMusicCarrier();
	}

	public void deleteAll() {
		book.clear();
		magazine.clear();
		cd.clear();
		vinyl.clear();
		cassette.clear();
		myDataBase.saveBook(this.book);
		myDataBase.saveMagazine(this.magazine);
		myDataBase.saveCd(this.cd);
		myDataBase.saveVinyl(this.vinyl);
		myDataBase.saveCassettes(this.cassette);
	}

	public void deleteBook(String key) {
		book.remove(key);
		myDataBase.saveBook(this.book);
	}

	public void deleteMagazine(String key) {
		magazine.remove(key);
		myDataBase.saveMagazine(this.magazine);
	}

	public void deleteCd(String key) {
		cd.remove(key);
		myDataBase.saveCd(this.cd);
	}

	public void deleteVinyl(String key) {
		vinyl.remove(key);
		myDataBase.saveVinyl(this.vinyl);
	}

	public void deleteCassette(String key) {
		cassette.remove(key);
		myDataBase.saveCassettes(this.cassette);
	}

	public void saveWarehouseCsv() {
		CsvTools csv = new CsvTools();
		String fileHeader = "Warehouse\nKIND OF PRODUCT,TITLE,PERFORMER,AUTHOR,PAGES,PUBLISHER,ISBN,ISSN,YEAR,VOLUME,EDITION,SIZE,TYPE,PRICE";
		String nameFile = "Warehouse.csv";
		csv.saveWarehose(book, magazine, cd, vinyl, cassette, fileHeader, nameFile);
	}
	
}
