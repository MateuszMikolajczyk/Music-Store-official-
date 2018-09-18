package data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.util.HashMap;

public class MyDatabase {

	public static final String MY_DATABASE_PUBLICATIONS_FILE_NAME = "My Database Publications.obj";
	public static final String MY_DATABASE_MUSIC_CARRIERS_FILE_NAME = "My Database Music Carriers.obj";

	public void savePublication(HashMap<String, Publications> publications) {

		try (ObjectOutputStream os = new ObjectOutputStream(
				new FileOutputStream(MY_DATABASE_PUBLICATIONS_FILE_NAME));) {

			os.writeObject(publications);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Save publication to the My Database is succesfull");
	}

	public void saveMusicCarriers(HashMap<String, MusicCarriers> miusicCarriers) {

		try (ObjectOutputStream os = new ObjectOutputStream(
				new FileOutputStream(MY_DATABASE_MUSIC_CARRIERS_FILE_NAME));) {

			os.writeObject(miusicCarriers);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Save miusicCarriers to the My Database is succesfull");
	}

}
