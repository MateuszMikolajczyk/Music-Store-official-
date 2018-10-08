package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.HashMap;

import additionalFunctions.CsvTools;

public class Warehouse {

	private HashMap<String, Book> books;
	private HashMap<String, Magazine> magazines;
	private HashMap<String, Cd> cds;
	private HashMap<String, Vinyl> vinyls;
	private HashMap<String, Cassette> cassettes;
	private MyDatabase myDataBase = new MyDatabase();

	public Warehouse() {
		books = new HashMap<>();
		magazines = new HashMap<>();
		cds = new HashMap<>();
		vinyls = new HashMap<>();
		cassettes = new HashMap<>();
		loadDataFromMyDatabase();
	}

	private void loadDataFromMyDatabase() {
		Path pathBooks = Paths.get(MyDatabase.MY_DATABASE_BOOKS_FILE_NAME);
		Path pathMagazines = Paths.get(MyDatabase.MY_DATABASE_MAGAZINES_FILE_NAME);
		Path pathCd = Paths.get(MyDatabase.MY_DATABASE_CDS_FILE_NAME);
		Path pathVinyls = Paths.get(MyDatabase.MY_DATABASE_VINYLS_FILE_NAME);
		Path pathCassettes = Paths.get(MyDatabase.MY_DATABASE_CASSETTES_FILE_NAME);
		if (Files.exists(pathBooks)) {
			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(MyDatabase.MY_DATABASE_BOOKS_FILE_NAME));) {

				books = (HashMap<String, Book>) ois.readObject();

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

				magazines = (HashMap<String, Magazine>) ois.readObject();

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

				cds = (HashMap<String, Cd>) ois.readObject();

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

				vinyls = (HashMap<String, Vinyl>) ois.readObject();

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

				cassettes = (HashMap<String, Cassette>) ois.readObject();

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

		if (this.books.get(bookKey) != null) {
			System.out.println("This publication already exists");
			return false;
		} else {
			this.books.put(bookKey, book);
			myDataBase.saveBook(this.books);
			return true;
		}
	}

	public boolean addMagazine(Magazine magazine) {
		String magazineKey = magazine.getTitle();

		if (this.magazines.get(magazineKey) != null) {
			System.out.println("This publication already exists");
			return false;
		} else {
			this.magazines.put(magazineKey, magazine);
			myDataBase.saveMagazine(this.magazines);
			return true;
		}
	}

	public boolean addCd(Cd cd) {
		String cdKey = cd.getPerformer() + " " + cd.getTitle();

		if (this.cds.get(cdKey) != null) {
			System.out.println("This music carrier already exists");
			return false;
		} else {
			this.cds.put(cdKey, cd);
			myDataBase.saveCd(this.cds);
			return true;
		}
	}

	public boolean addVinyl(Vinyl vinyl) {
		String vinylKey = vinyl.getPerformer() + " " + vinyl.getTitle();

		if (this.vinyls.get(vinylKey) != null) {
			System.out.println("This music carrier already exists");
			return false;
		} else {
			this.vinyls.put(vinylKey, vinyl);
			myDataBase.saveVinyl(this.vinyls);
			return true;
		}
	}

	public boolean addCassette(Cassette cassette) {
		String cassetteKey = cassette.getPerformer() + " " + cassette.getTitle();

		if (this.cassettes.get(cassetteKey) != null) {
			System.out.println("This music carrier already exists");
			return false;
		} else {
			this.cassettes.put(cassetteKey, cassette);
			myDataBase.saveCassettes(this.cassettes);
			return true;
		}
	}

	public Book getBooks(String title) {
		return books.get(title);
	}

	public Magazine getMagazines(String title) {
		return magazines.get(title);
	}

	public Cd getCds(String title, String performer) {
		String performerPlusTitle = performer + " " + title;
		return cds.get(performerPlusTitle);
	}

	public Vinyl getVinyls(String title, String performer) {
		String performerPlusTitle = performer + " " + title;
		return vinyls.get(performerPlusTitle);
	}

	public Cassette getCassettes(String title, String performer) {
		String performerPlusTitle = performer + " " + title;
		return cassettes.get(performerPlusTitle);
	}

	public void getAllPublication() {
		System.out.println("PUBLICATIONS\n" + "---------------------\n" + "BOOKS\n" + books.values() + "\nMAGAZINES\n"
				+ magazines.values() + "\n");
	}

	public void getAllMusicCarrier() {
		System.out.println("MUSIC CARRIERS\n" + "---------------------\n" + "CDs\n" + cds.values() + "\nVINYLS\n"
				+ vinyls.values() + "\nCASSETTES\n" + cassettes.values() + "\n");
	}

	public void getAllWarehouse() {
		getAllPublication();
		getAllMusicCarrier();
	}

	public void deleteAll() {
		books.clear();
		magazines.clear();
		cds.clear();
		vinyls.clear();
		cassettes.clear();
		myDataBase.saveBook(this.books);
		myDataBase.saveMagazine(this.magazines);
		myDataBase.saveCd(this.cds);
		myDataBase.saveVinyl(this.vinyls);
		myDataBase.saveCassettes(this.cassettes);
	}

	public void deleteBook(String key) {
		books.remove(key);
		myDataBase.saveBook(this.books);
	}

	public void deleteMagazine(String key) {
		magazines.remove(key);
		myDataBase.saveMagazine(this.magazines);
	}

	public void deleteCd(String key) {
		cds.remove(key);
		myDataBase.saveCd(this.cds);
	}

	public void deleteVinyl(String key) {
		vinyls.remove(key);
		myDataBase.saveVinyl(this.vinyls);
	}

	public void deleteCassette(String key) {
		cassettes.remove(key);
		myDataBase.saveCassettes(this.cassettes);
	}

	public void saveWarehouseCsv() {
		CsvTools csv = new CsvTools();
		csv.saveBooks(books);
		csv.saveMagazines(magazines);
		csv.saveCds(cds);
		csv.saveCassettes(cassettes);
		csv.saveVinyls(vinyls);
	}

	public void logicForInsertDataToDataBase() {
		Connection connection = WarehouseJDBC.connect();
		WarehouseJDBC.createTables(connection);
		WarehouseJDBC.insertData(connection, books, magazines, cds, cassettes, vinyls);
		WarehouseJDBC.closeConnection(connection);
	}

	public void logicForLoadDataFromDataBase() {
		Connection connection = WarehouseJDBC.connect();
		WarehouseJDBC.loadDataFromDataBase(connection, books, magazines, cds, cassettes, vinyls);
		WarehouseJDBC.closeConnection(connection);
	}
	/*
	 * @Prepared methods for the future implementation of sorting logic.
	 * 
	 * public void sortWarehouseAlphabetical() {
	 * 
	 * }
	 * 
	 * public void sortWarehouseByPriceAscending() {
	 * 
	 * }
	 * 
	 * public void sortWarehouseByPriceDescending() {
	 * 
	 * }
	 * 
	 * public void sortWarehouseByTimeAndDateAdditionAscending() {
	 * 
	 * }
	 * 
	 * public void sortWarehouseByTimeAndDateAdditionDescending() {
	 * 
	 * }
	 */
}
