package by.gsu.epamlab;

/**
 * The class "PricePurchase" extends the class "Purchase". It is subclass for
 * the purchase with a price discount
 * 
 * @author Yuliya Krivitskaya
 *
 */
public class PricePurchase extends Purchase {
	
	/** the discount */
	private int discount;

	/**
	 * Constructor
	 * @param name - product name
	 * @param price - product price
	 * @param number - number of purchased products
	 * @param discount - price discount (should lower than price)
	 */
	public PricePurchase(String name, int price, int number, int discount) {
		super(name, price, number);
		this.discount = discount;
	}

	/**
	 * calculating the purchase cost
	 * 
	 * @return the purchase cost with discount
	 */
	@Override
	public int getCost() {

		return super.getCost() - getNumber() * discount;
	}

	/**
	 * a string representation of the object with discount
	 * @return string
	 */
	@Override
	public String toString() {

		return super.toString() + ";" + discount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
