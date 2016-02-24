package by.gsu.epamlab;


public class Runner {

	public static void main(String[] args) {

		// create an object from the developed class, loading vector’s element
		// from the main file
		PurchaseList first = new PurchaseList("in");

		// print the vector
		System.out.println("=======  after creation   ======");
		first.print();

		// create another object from developed class, loading vector’s element
		// from the additional file
		PurchaseList second = new PurchaseList("addon");

		// insert the last element of the second vector at the position 0 of the
		// first vector
		first.insert(0, second.getPurchase(second.getLastIndex()));

		// insert the initial element of the second vector at the position 1000
		// of the first vector
		first.insert(1000, second.getPurchase(0));

		// insert the element with index 2 of the second vector at the position
		// 2 of the first vector
		first.insert(2, second.getPurchase(2));

		// call the method for elements deleting three times – with arguments 3,
		// 10 and –5
		first.delete(3);
		first.delete(10);
		first.delete(-5);

		// print the first vector
		System.out.println("=======  before sorting   ======");
		first.print();

		// sort the first vector
		first.sort(new SortByName());

		// print the first vector;
		System.out.println("=======  after sorting   ======");
		first.print();
		


	
	}

}
