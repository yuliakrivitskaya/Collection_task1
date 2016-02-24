package by.gsu.epamlab;

/**
 * The class "CsvLineException" show Exception if any fields isn't fit
 * Constructor of Purchase
 * 
 * @author Yuliya Krivitskaya
 *
 */

public class CsvLineException extends Exception {

	public CsvLineException(String message) {
		super(message);
	}

	public CsvLineException(String message, String csvString) {
		super(message + " csvString: " + csvString);
	}

	public CsvLineException(String message, Exception e) {
		super(message, e);
	}

	public void show() {
		printStackTrace();
	}

}
