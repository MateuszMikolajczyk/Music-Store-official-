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

	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String COMAND_DELIMETER = ",";
	private final String fileHeaderForBooks = "BOOKS\nKIND OF PRODUCT,TITLE,AUTHOR,PAGES,PUBLISHER,ISBN,PRICE";
	private final String fileHeaderForMagazines = "MAGAZINES\nKIND OF PRODUCT,TITLE,PAGES,PUBLISHER,ISSN,YEAR,VOLUME,EDITION,PRICE";
	private final String fileHeaderForCds = "CDs\nKIND OF PRODUCT,TITLE,PUBLISHER,PERFORMER,PRICE";
	private final String fileHeaderForCassettes = "CASSETTES\nKIND OF PRODUCT,TITLE,PUBLISHER,PERFORMER,PRICE";
	private final String fileHeaderForVinyls = "VINYLS\nKIND OF PRODUCT,TITLE,PUBLISHER,PERFORMER,SIZE,TYPE,PRICE";
	private final String nameFileForBooks = "Books.csv";
	private final String nameFileForMagazines = "Magazines.csv";
	private final String nameFileForCds = "CDs.csv";
	private final String nameFileForCassettes = "Cassettes.csv";
	private final String nameFileForVinyls = "Vinyls.csv";

	public void saveBooks(HashMap<String, Book> book) {

		try (FileWriter fileWriter = new FileWriter(nameFileForBooks);) {
			fileWriter.append(fileHeaderForBooks);
			fileWriter.append(NEW_LINE_SEPARATOR);
			for (Book entry : book.values()) {
				fileWriter.append("BOOK");
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getTitle()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getAuthor()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPages()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPublisher()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getIsbn()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPrice()));
				fileWriter.append(NEW_LINE_SEPARATOR);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("END OF SAVING FILE \"Books.csv\"");
	}

	public void saveMagazines(HashMap<String, Magazine> magazine) {
		try (FileWriter fileWriter = new FileWriter(nameFileForMagazines);) {
			fileWriter.append(fileHeaderForMagazines);
			fileWriter.append(NEW_LINE_SEPARATOR);
			for (Magazine entry : magazine.values()) {
				fileWriter.append("MAGAZINE");
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getTitle()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPages()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPublisher()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getIssn()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getYear()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getVolume()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getEdition()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPrice()));
				fileWriter.append(NEW_LINE_SEPARATOR);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("END OF SAVING FILE \"Magazines.csv\"");

	}

	public void saveCds(HashMap<String, Cd> cd) {
		try (FileWriter fileWriter = new FileWriter(nameFileForCds);) {
			fileWriter.append(fileHeaderForCds);
			fileWriter.append(NEW_LINE_SEPARATOR);
			for (Cd entry : cd.values()) {
				fileWriter.append("CD");
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getTitle()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPerformer()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPublisher()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPrice()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("END OF SAVING FILE \"CDs.csv\"");
	}

	public void saveVinyls(HashMap<String, Vinyl> vinyl) {
		try (FileWriter fileWriter = new FileWriter(nameFileForVinyls);) {
			fileWriter.append(fileHeaderForVinyls);
			fileWriter.append(NEW_LINE_SEPARATOR);
			for (Vinyl entry : vinyl.values()) {
				fileWriter.append("VINYL");
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getTitle()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPerformer()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPublisher()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getSize()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getType()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPrice()));
				fileWriter.append(NEW_LINE_SEPARATOR);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("END OF SAVING FILE \"Vinyls.csv\"");
	}

	public void saveCassettes(HashMap<String, Cassette> cassette) {
		try (FileWriter fileWriter = new FileWriter(nameFileForCassettes);) {
			fileWriter.append(fileHeaderForCassettes);
			fileWriter.append(NEW_LINE_SEPARATOR);
			for (Cassette entry : cassette.values()) {
				fileWriter.append("CASSETTE");
				fileWriter.append(String.valueOf(entry.getTitle()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPerformer()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPublisher()));
				fileWriter.append(COMAND_DELIMETER);
				fileWriter.append(String.valueOf(entry.getPrice()));
				fileWriter.append(NEW_LINE_SEPARATOR);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("END OF SAVING FILE \"Cassettes.csv\"");
	}
}