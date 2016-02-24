package by.gsu.epamlab;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The class "PurchaseList" does list of Purchase from csv–file
 * 
 * @author Yuliya Krivitskaya
 *
 */
public class PurchaseList {

	/** vector (reference to List<Purchase>) */
	private List<Purchase> purchases;

	/**
	 * Constructor
	 */
	public PurchaseList() {
		purchases = new ArrayList<Purchase>();
	}

	/**
	 * Constructor with the parameter – csv–filename, loading elements into the
	 * vector from a csv–file. To return an empty vector if some problem with a
	 * csv–file reading exists
	 * 
	 * @param filename
	 *            - name of csv file
	 * @return list of purchases from file
	 */
	public PurchaseList(String filename) {
		purchases = new ArrayList<Purchase>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename + ".csv"))) {
			// read to line
			String s;
			while ((s = br.readLine()) != null) {
				try {
					Purchase t = createPurchase(s);
					if (t != null)
						purchases.add(t);
				} catch (CsvLineException e) {
					e.show();
				}
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

	/**
	 * Creating an element, corresponding to a purchase, on the string in the
	 * csv–format
	 * 
	 * @param csvString
	 *            - input csvString
	 * @return Purchase if csvString doesn't have any errors
	 * @throws CsvLineException
	 *             - if csvString have any errors
	 */
	private Purchase createPurchase(String csvString) throws CsvLineException {
		String[] params;
		String name;
		int[] intParams = new int[3];
		Purchase t;

		// split csvString to String[] separated by a semicolon
		params = csvString.split(";");
		if (params.length < 3 || params.length > 4) {
			throw new CsvLineException("Does not correspond to the fields of class Purchase");
		}
		name = params[0];
		if ("".equals(name)) {
			throw new CsvLineException("Empty name");
		}
		// parse to Integer from String[] element 1-3
		for (int i = 1; i < params.length; i++) {
			try {
				intParams[i - 1] = Integer.parseInt(params[i]);
			} catch (NumberFormatException e) {
				throw new CsvLineException("Illegal param type", e);
			}
		}
		if (intParams[2] < 0) {
			throw new CsvLineException("Illegal param value: discount can't be negative");
		}
		if (intParams[0] == 0 || intParams[1] == 0)
			throw new CsvLineException("Illegal param value");
		if (intParams[2] != 0)
			t = new PricePurchase(name, intParams[0], intParams[1], intParams[2]);
		else
			t = new Purchase(name, intParams[0], intParams[1]);
		if (t.getCost() < 0) {
			throw new CsvLineException("Illegal param value: Cost can't be negative");
		}
		return t;
	}

	/**
	 * inserting referenced object into the vector at the index position; if the
	 * index value is wrong the object should be inserted at the end of the
	 * vector
	 * 
	 * @param index
	 *            - index at which the specified element is to be inserted
	 * @param ref
	 *            - Purchase to be inserted
	 */
	public void insert(int index, Purchase ref) {
		if (index > (purchases.size() - 1) || index < 0)
			purchases.add(ref);
		else
			purchases.add(index, ref);
	}

	/**
	 * deleting single element by it’s index; if the index value is wrong the
	 * method should return –1, otherwise – index
	 * 
	 * @param index
	 *            - index at which the specified element is to be deleted
	 * @return –1, otherwise – index
	 */
	public int delete(int index) {
		if (index > (purchases.size() - 1) || index < 0) {
			return 1;
		} else {
			purchases.remove(index);
			return index;
		}
	}

	/**
	 * calculating the total cost of all purchases
	 * 
	 * @return total cost of all purchases
	 */
	public int totalCost() {
		int result = 0;
		for (Purchase purchase : purchases)
			result += purchase.getCost();
		return result;
	}

	/**
	 * printing vector in the table form and the total cost of all purchases
	 */
	public void print() {
		for (Purchase purchase : purchases) {
			System.out.println(purchase.toString());
		}
		System.out.println("Total cost     " + totalCost());
	}

	/**
	 * sorting the vector by a given comparator
	 * 
	 * @param comparator
	 *            - the comparator class implementing interface Comparator
	 *            <Purchase>
	 */
	public void sort(Comparator<Purchase> comparator) {
		Collections.sort(purchases, comparator);
	}

	/**
	 * get Purchase by index
	 * 
	 * @param index
	 *            - index of purchase throw the List which found
	 * @return Purchase
	 */
	public Purchase getPurchase(int index) {
		return purchases.get(index);
	}

	/**
	 * Get Purchase of last index
	 * 
	 * @return Purchase of last index
	 */
	public int getLastIndex() {
		return purchases.size() - 1;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
}