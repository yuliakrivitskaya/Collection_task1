package by.gsu.epamlab;

/**
 * The class "Purchase" is the superclass, describing the commodity purchase
 * 
 * @author Yuliya Krivitskaya
 *
 */

public class Purchase {
	
	/** commodity name */
	private String name;

	/** price in belarusian rubles */
	private int price;

	/** number of purchased units */
	private int number;

	/**
	 * Constructor
	 * @param name - product name
	 * @param price - product price
	 * @param number - number of purchased products
	 */
	public Purchase(String name, int price, int number) {
		super();
		this.name = name;
		this.price = price;
		this.number = number;
	}

	/**
	 * calculating the purchase cost
	 * 
	 * @return the purchase cost
	 */
	public int getCost(){
		
		return price * number;

	};

	/**
	 * Converting of an object to a string in the following format: each field
	 * and the purchase cost, separated by the ";" symbol)
	 * @return string
	 */
	public String toString() {
		return name + ";" + price + ";" + number + ";" + getCost();
	}

	/**
	 * Comparing of purchases (equal if name and price are the same)
	 * @return true if equals
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(getClass() == obj.getClass()))
			return false;
		else {
			Purchase tmp = (Purchase) obj;
			if (tmp.name == this.name)
				return true;
			else
				return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
