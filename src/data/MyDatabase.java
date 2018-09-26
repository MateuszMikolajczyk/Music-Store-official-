package data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.util.HashMap;

public class MyDatabase {

	public static final String MY_DATABASE_BOOKS_FILE_NAME = "My Database Books.obj";
	public static final String MY_DATABASE_MAGAZINES_FILE_NAME = "My Database Magazines.obj";
	public static final String MY_DATABASE_CDS_FILE_NAME = "My Database CDs.obj";
	public static final String MY_DATABASE_VINYLS_FILE_NAME = "My Database Vinyls.obj";
	public static final String MY_DATABASE_CASSETTES_FILE_NAME = "My Database Cassettes.obj";

	public void saveBook(HashMap<String, Book> book) {

		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(MY_DATABASE_BOOKS_FILE_NAME));) {

			os.writeObject(book);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Save books to the MY DATABASE is succesfull");
	}

	public void saveMagazine(HashMap<String, Magazine> magazine) {

		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(MY_DATABASE_MAGAZINES_FILE_NAME));) {

			os.writeObject(magazine);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Save magazines to the MY DATABASE is succesfull");
	}

	public void saveCd(HashMap<String, Cd> cd) {

		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(MY_DATABASE_CDS_FILE_NAME));) {

			os.writeObject(cd);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Save CDs to the MY DATABASE is succesfull");
	}

	public void saveVinyl(HashMap<String, Vinyl> vinyl) {

		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(MY_DATABASE_VINYLS_FILE_NAME));) {

			os.writeObject(vinyl);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Save vinyls to the MY DATABASE is succesfull");
	}

	public void saveCassettes(HashMap<String, Cassette> cassete) {

		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(MY_DATABASE_CASSETTES_FILE_NAME));) {

			os.writeObject(cassete);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Save cassettes to the MY DATABASE is succesfull");
	}
}
