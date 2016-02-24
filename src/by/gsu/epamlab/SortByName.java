package by.gsu.epamlab;

import java.util.Comparator;

/**
 * Sort purchases by name
 * 
 * @author Yuliya Krivitskaya
 *
 */

public class SortByName implements Comparator<Purchase> {
	/**
	 * compare on the String field increasing
	 */
	@Override
	public int compare(Purchase s0, Purchase s1) {

		String str1 = s0.getName();
		String str2 = s1.getName();
		// if two values are equal then superclass object is less a subclass
		// one, if objects belong to the same class then on the purchase cost
		// increasing
		if (str1.compareTo(str2) == 0) {
			if (s0 instanceof Purchase)
				return -1;
			else
				return 1;
		} else
			return str1.compareTo(str2);
	}

}
