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

	HashMap<String, Publications> publications;
	HashMap<String, MusicCarriers> musicCarriers;
	public MyDatabase myDataBase = new MyDatabase();

	public Warehouse() {
		publications = new HashMap<>();
		musicCarriers = new HashMap<>();
		loadDataFromMyDatabase();
	}

	public void loadDataFromMyDatabase() {
		Path pathPublications = Paths.get(MyDatabase.MY_DATABASE_PUBLICATIONS_FILE_NAME);
		Path pathMusicCarriers = Paths.get(MyDatabase.MY_DATABASE_MUSIC_CARRIERS_FILE_NAME);
		if (Files.exists(pathPublications)) {
			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(MyDatabase.MY_DATABASE_PUBLICATIONS_FILE_NAME));) {

				publications = (HashMap<String, Publications>) ois.readObject();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (Files.exists(pathMusicCarriers)) {
			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(MyDatabase.MY_DATABASE_MUSIC_CARRIERS_FILE_NAME));) {

				musicCarriers = (HashMap<String, MusicCarriers>) ois.readObject();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean addPublications(Publications publications) {
		String pubKey = publications.getTitle();

		if (this.publications.get(pubKey) != null) {
			System.out.println("This publication already exists");
			return false;
		} else {
			this.publications.put(pubKey, publications);
			myDataBase.savePublication(this.publications);
			return true;
		}
	}

	public boolean addMusicCarriers(MusicCarriers musicCarriers) {
		String musKey = musicCarriers.getPerformer() + " " + musicCarriers.getTitle();

		if (this.musicCarriers.get(musKey) != null) {
			System.out.println("This music carriers already exists");
			return false;
		} else {
			this.musicCarriers.put(musKey, musicCarriers);
			myDataBase.saveMusicCarriers(this.musicCarriers);
			return true;
		}
	}

	public Publications getPublication(String title) {
		return publications.get(title);
	}

	public MusicCarriers getMusicCarrier(String title, String performer) {
		String performerPlusTitle = performer + " " + title;
		return musicCarriers.get(performerPlusTitle);
	}

	public void getAllPublication() {
		System.out.println("PUBLICATIONS\n" + publications.values());
	}

	public void getAllMusicCarrier() {
		System.out.println("MUSIC CARRIERS\n" + musicCarriers.values());
	}

	public void getAllWarehouse() {
		System.out.println("PUBLICATIONS\n" + publications.values());
		System.out.println("MUSIC CARRIERS\n" + musicCarriers.values());
	}

	public void deleteAll() {
		publications.clear();
		musicCarriers.clear();
		myDataBase.savePublication(this.publications);
		myDataBase.saveMusicCarriers(this.musicCarriers);
	}

	public void deletePublication(String key) {
		publications.remove(key);
		myDataBase.savePublication(this.publications);
	}

	public void deleteMusicCarrier(String key) {
		musicCarriers.remove(key);
	}

	public void savePublicationCsv() {
		CsvTools csv = new CsvTools();
		String fileHeader = "Publications\nTitle,Price,Pages,Publisher";
		String nameFile ="Publications.csv";
		csv.savePublicationsCsv(publications, fileHeader, nameFile);
	}
	
	public void saveMusicCarriersCsv() {
		CsvTools csv = new CsvTools();
		String fileHeader = "Music Carriers\nPerformer,Title,Price,Carrier,Publisher";
		String nameFile ="Music Carriers.csv";
		csv.saveMusicCarriersCsv(musicCarriers, fileHeader, nameFile);;
	}
}
