package additionalFunctions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import data.Book;
import data.Cassette;
import data.Cd;
import data.Magazine;
import data.Vinyl;

public class CsvTools {

	public void saveWarehose(HashMap<String, Book> book, HashMap<String, Magazine> magazine, HashMap<String, Cd> cd,
			HashMap<String, Vinyl> vinyl, HashMap<String, Cassette> cassette, String fileHeader, String nameFile) {

		FileWriter fileWriter = null;
		final String newLineSeparator = "\n";
		final String comandDelimiter = ",";
		
		try {
			fileWriter = new FileWriter(nameFile);
			fileWriter.append(fileHeader);
			fileWriter.append(newLineSeparator);
			for (Book entry : book.values()) {
				String nameOfClass = String.valueOf(entry.getClass());
				fileWriter.append(nameOfClass.substring(11,15));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getTitle()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getAuthor()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPages()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPublisher()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getIsbn()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPrice()));
				fileWriter.append(newLineSeparator);

			}

			for (Magazine entry : magazine.values()) {
				String nameOfClass = String.valueOf(entry.getClass());
				fileWriter.append(nameOfClass.substring(11,19));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getTitle()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPages()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPublisher()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getIssn()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getYear()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getVolume()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getEdition()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPrice()));
				fileWriter.append(newLineSeparator);
				
			}

			for (Cd entry : cd.values()) {
				String nameOfClass = String.valueOf(entry.getClass());
				fileWriter.append(nameOfClass.substring(11,13));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getTitle()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPerformer()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPublisher()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPrice()));
				fileWriter.append(newLineSeparator);
			}

			for (Vinyl entry : vinyl.values()) {
				String nameOfClass = String.valueOf(entry.getClass());
				fileWriter.append(nameOfClass.substring(11,16));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getTitle()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPerformer()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPublisher()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getSize()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getType()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPrice()));
				fileWriter.append(newLineSeparator);

			}

			for (Cassette entry : cassette.values()) {
				String nameOfClass = String.valueOf(entry.getClass());
				fileWriter.append(nameOfClass.substring(11,19));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getTitle()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPerformer()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPublisher()));
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(comandDelimiter);
				fileWriter.append(String.valueOf(entry.getPrice()));
				fileWriter.append(newLineSeparator);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in CsvFileWriter !!!");
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("END OF SAVEING CSV FILE");
		}

	}
	
}
