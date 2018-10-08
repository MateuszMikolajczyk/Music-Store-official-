package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class WarehouseJDBC {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:musicStore.db";

	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(DB_URL);
			System.out.println("You have connected to the database");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problem with opening the connection");
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("No JDBC driver");
			return null;
		}
		return connection;
	}

	public static void createTables(Connection connection) {
		Statement stat = null;
		try {
			String createBooks = "CREATE TABLE IF NOT EXISTS books(title varchar(100),pages varchar(100),publisher varchar(100),author varchar(100),isbn varchar(100),price int,time timestamp,date date)";
			String createMagazines = "CREATE TABLE IF NOT EXISTS magazines(title varchar(100),pages varchar(100),publisher varchar(100),issn varchar(100),year int,volume int,edition varchar(100),price int,time timestamp,date date)";
			String createCds = "CREATE TABLE IF NOT EXISTS cds(title varchar(100),publisher varchar(100),performer varchar(100),price int,time timestamp,date date)";
			String createCassette = "CREATE TABLE IF NOT EXISTS cassettes(title varchar(100),publisher varchar(100),performer varchar(100),price int,time timestamp,date date)";
			String createVinyls = "CREATE TABLE IF NOT EXISTS vinyls(title varchar(100),publisher varchar(100),performer varchar(100),size varchar(100),type varchar(100),price int,time timestamp,date date)";
			stat = connection.createStatement();
			stat.execute(createBooks);
			stat.execute(createMagazines);
			stat.execute(createCds);
			stat.execute(createCassette);
			stat.execute(createVinyls);
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("The table can not be created");
		}

	}

	public static void insertData(Connection connection, HashMap<String, Book> books,
			HashMap<String, Magazine> magazines, HashMap<String, Cd> cds, HashMap<String, Cassette> cassettes,
			HashMap<String, Vinyl> vinyls) {

		String insertBooks = null;
		String insertMagazines = null;
		String insertCds = null;
		String insertCassette = null;
		String insertVinyls = null;
		Statement stat = null;
		try {
			stat = connection.createStatement();
			String clearBooks = "DELETE FROM books";
			String clearMagazines = "DELETE FROM magazines";
			String clearCds = "DELETE FROM cds";
			String clearCassettes = "DELETE FROM cassettes";
			String clearVinyls = "DELETE FROM vinyls";
			stat.execute(clearBooks);
			stat.execute(clearMagazines);
			stat.execute(clearCds);
			stat.execute(clearCassettes);
			stat.execute(clearVinyls);
			for (Book entry : books.values()) {
				insertBooks = "INSERT INTO books VALUES (" + "'" + entry.getTitle() + "'" + "," + "'" + entry.getPages()
						+ "'" + "," + "'" + entry.getPublisher() + "'" + "," + "'" + entry.getAuthor() + "'" + "," + "'"
						+ entry.getIsbn() + "'" + "," + "'" + entry.getPrice() + "'" + "," + "'" + entry.getTime() + "'"
						+ "," + "'" + entry.getDate() + "'" + ");";
				stat.execute(insertBooks);
			}
			for (Magazine entry : magazines.values()) {
				insertMagazines = "INSERT INTO magazines VALUES (" + "'" + entry.getTitle() + "'" + "," + "'"
						+ entry.getPages() + "'" + "," + "'" + entry.getPublisher() + "'" + "," + "'" + entry.getIssn()
						+ "'" + "," + "'" + entry.getYear() + "'" + "," + "'" + entry.getVolume() + "'" + "," + "'"
						+ entry.getEdition() + "'" + "," + "'" + entry.getPrice() + "'" + "," + "'" + entry.getTime()
						+ "'" + "," + "'" + entry.getDate() + "'" + ");";
				stat.execute(insertMagazines);
			}
			for (Cd entry : cds.values()) {
				insertCds = "INSERT INTO cds VALUES (" + "'" + entry.getTitle() + "'" + "," + "'" + entry.getPublisher()
						+ "'" + "," + "'" + entry.getPerformer() + "'" + "," + "'" + entry.getPrice() + "'" + "," + "'"
						+ entry.getTime() + "'" + "," + "'" + entry.getDate() + "'" + ");";
				stat.execute(insertCds);
			}
			for (Cassette entry : cassettes.values()) {
				insertCassette = "INSERT INTO cassettes VALUES (" + "'" + entry.getTitle() + "'" + "," + "'"
						+ entry.getPublisher() + "'" + "," + "'" + entry.getPerformer() + "'" + "," + "'"
						+ entry.getPrice() + "'" + "," + "'" + entry.getTime() + "'" + "," + "'" + entry.getDate() + "'"
						+ ");";
				stat.execute(insertCassette);
			}
			for (Vinyl entry : vinyls.values()) {
				insertVinyls = "INSERT INTO vinyls VALUES (" + "'" + entry.getTitle() + "'" + "," + "'"
						+ entry.getPublisher() + "'" + "," + "'" + entry.getPerformer() + "'" + "," + "'"
						+ entry.getSize() + "'" + "," + "'" + entry.getType() + "'" + "," + "'" + entry.getPrice() + "'"
						+ "," + "'" + entry.getTime() + "'" + "," + "'" + entry.getDate() + "'" + ");";
				stat.execute(insertVinyls);
			}

			stat.close();
			System.out.println("The command was executed");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("I can't add data");
		}

	}

	public static void loadDataFromDataBase(Connection connection, HashMap<String, Book> books,
			HashMap<String, Magazine> magazines, HashMap<String, Cd> cds, HashMap<String, Cassette> cassettes,
			HashMap<String, Vinyl> vinyls) {
		Statement stat = null;
		try {
			stat = connection.createStatement();
			String loadBooks = "SELECT * FROM books";
			String loadMagazines = "SELECT * FROM magazines";
			String loadCds = "SELECT * FROM cds";
			String loadCassette = "SELECT * FROM cassettes";
			String loadVinyls = "SELECT * FROM vinyls";

			books.clear();
			magazines.clear();
			cds.clear();
			cassettes.clear();
			vinyls.clear();
			ResultSet resultForBooks = stat.executeQuery(loadBooks);
			while (resultForBooks.next()) {

				Book book = new Book(resultForBooks.getString("title"), resultForBooks.getString("pages"),
						resultForBooks.getString("publisher"), resultForBooks.getString("author"),
						resultForBooks.getString("isbn"), resultForBooks.getInt("price"));
				books.put(resultForBooks.getString("title"), book);
			}
			ResultSet resultForMagazines = stat.executeQuery(loadMagazines);
			while (resultForMagazines.next()) {
				int price = resultForMagazines.getInt("price");
				int year = resultForMagazines.getInt("year");
				int volume = resultForMagazines.getInt("volume");
				Magazine magazine = new Magazine(resultForMagazines.getString("title"),
						resultForMagazines.getString("pages"), resultForMagazines.getString("publisher"),
						resultForMagazines.getString("edition"), resultForMagazines.getString("issn"), year, volume,
						price);
				magazines.put(resultForMagazines.getString("title"), magazine);
			}
			ResultSet resultForCds = stat.executeQuery(loadCds);
			while (resultForCds.next()) {
				int price = resultForCds.getInt("price");
				String key = resultForCds.getString("performer") + " " + resultForCds.getString("title");
				Cd cd = new Cd(resultForCds.getString("performer"), resultForCds.getString("title"),
						resultForCds.getString("publisher"), price);
				cds.put(key, cd);
			}
			ResultSet resultForCassettes = stat.executeQuery(loadCassette);
			while (resultForCassettes.next()) {
				int price = resultForCassettes.getInt("price");
				String key = resultForCassettes.getString("performer") + " " + resultForCassettes.getString("title");
				Cassette cassette = new Cassette(resultForCassettes.getString("performer"),
						resultForCassettes.getString("title"), resultForCassettes.getString("publisher"), price);
				cassettes.put(key, cassette);
			}
			ResultSet resultForVinyls = stat.executeQuery(loadVinyls);
			while (resultForVinyls.next()) {
				int price = resultForVinyls.getInt("price");
				String key = resultForVinyls.getString("performer") + " " + resultForVinyls.getString("title");
				Vinyl vinyl = new Vinyl(resultForVinyls.getString("performer"), resultForVinyls.getString("title"),
						resultForVinyls.getString("publisher"), price, resultForVinyls.getString("size"),
						resultForVinyls.getString("type"));
				vinyls.put(key, vinyl);
			}
			stat.close();
			System.out.println("The command was executed");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("I can't load data");
		}

	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}