package additionalFunctions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import data.MusicCarriers;
import data.Publications;

public class CsvTools {

	public void savePublicationsCsv(HashMap<String, Publications> publications, String fileHeader, String nameFile) {

		FileWriter fileWriter = null;
		final String newLineSeparator = "\n";
		final String comandDelimiter = ",";
		try {
			fileWriter = new FileWriter(nameFile);
			fileWriter.append(fileHeader);
			fileWriter.append(newLineSeparator);
			Set<HashMap.Entry<String, Publications>> entries = publications.entrySet();
			for (HashMap.Entry<String, Publications> entry : entries) {
				fileWriter.append(String.valueOf(entry.getValue().getTitle()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getValue().getPrice()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getValue().getPages()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getValue().getPublisher()));
				fileWriter.append(newLineSeparator);
			}

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("END OF SAVEING PUBLICATIONS TO CSV");
		}

	}

	public void saveMusicCarriersCsv(HashMap<String, MusicCarriers> musicCarriers, String fileHeader, String nameFile) {

		FileWriter fileWriter = null;
		final String newLineSeparator = "\n";
		final String comandDelimiter = ",";
		try {
			fileWriter = new FileWriter(nameFile);
			fileWriter.append(fileHeader);
			fileWriter.append(newLineSeparator);
			Set<HashMap.Entry<String, MusicCarriers>> entries = musicCarriers.entrySet();
			for (HashMap.Entry<String, MusicCarriers> entry : entries) {
				fileWriter.append(String.valueOf(entry.getValue().getPerformer()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getValue().getTitle()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getValue().getPrice()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getValue().getCarrier()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getValue().getPublisher()));
				fileWriter.append(newLineSeparator);
			}

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("END OF SAVEING MUSIC CARRIERS TO CSV");
		}

	}
}
