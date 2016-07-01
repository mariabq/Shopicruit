/**
 * 
 */
package Shopicruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Maria BQ
 *
 */
public class Store {

	private String name;
	HashSet<Product> shopicruit = new HashSet<Product>();
	List<Product> shoppingCart = new ArrayList<Product>();
	int difference = 0;

	/**
	 * Add products to cart and sorts them in ascending order based on price
	 */
	public void addToCart() {

		// adds produtcs to shoppingCart
		for (Product prod : shopicruit)
			if (checkTitle(prod) == true && checkDuplicate(prod) == false) {
				shoppingCart.add(prod);
			}

		// sorts them in ascending order based on price
		Collections.sort(shoppingCart);
	}

	/**
	 * Check if the number of keyboards mathces the number of computers
	 * and calculates difference
	 */
	public void checkCart() {

		for (Product prod : shoppingCart) {

			// Split the product title into an array of strings
			String[] parsedTitle = prod.getTitle().split(" ");

			// checks which product is a keyboard and which is a computer
			// and counts them
			String k = "keyboard";
			int noOfKbrd = 0;
			int noOfComp = 0;

			for (String keyWord : parsedTitle) {
				if (keyWord.equals(k)) {
					noOfKbrd++;
				} else {
					noOfComp++;
				}
			}

			// calculates difference
			difference = noOfKbrd - noOfComp;
		}
	}
	
	/**
	 * If there is a difference in number between the two categories of products,
	 * it will delete from the shopping cart as many items of the product that exceeds
	 * so that it is balanced
	 */
	public void balanceProducts() {

		if (difference == 0) {

			System.out.println("The number of keyboards is equal with the number of computers");

		} else if (difference > 0) {

			System.out.println("The number of keyboards exceeds the number of computers by: " + difference);
			for (int i = difference; i > 0; i--) {

				for (Product prod : shoppingCart) {

					// Split the product title into an array of strings
					String[] parsedTitle = prod.getTitle().replace(" ", "").split(" ");

					// checks if the product is a keyboard
					String k = "keyboard";

					for (String keyWord : parsedTitle) {
						if (keyWord.equals(k)) {
							shoppingCart.remove(prod);
						}
					}
				}
			}

		} else if (difference < 0) {
			
			System.out.println("The number of computers exceeds the number of keyboards by: " + (difference * -1));
			for (int i = difference; i < 0; i++) {

				for (Product prod : shoppingCart) {

					// Split the product title into an array of strings
					String[] parsedTitle = prod.getTitle().replace(" ", "").split(" ");

					// checks if the product is a computer
					String c = "computer";

					for (String keyWord : parsedTitle) {
						if (keyWord.equals(c)) {
							shoppingCart.remove(prod);
						}
					}
				}
			}
		}
	}

	/**
	 * Calculates the total weight of the products bought
	 */
	public int getTotalWeight() {
		int grams = 0;
		for (Product prod : shoppingCart) {
			grams += prod.getWeightInGrams();
		}
		return grams;
	}

	/**
	 * Calculates the total price of the products bought
	 */
	public int getTotalPrice() {
		int price = 0;
		for (Product prod : shoppingCart) {
			price += prod.getPrice();
		}
		return price;
	}

	/**
	 * Buy method provides information about the total weight and price of the
	 * products bought
	 */
	public void buy() {
		int value = getTotalPrice();
		int weight = getTotalWeight();
		System.out.println("The total value of your purchase is: " + value);
		System.out.println("The total weight of your products is: " + weight);
	}

	/**
	 * Checks if the product is a keyboard or computer
	 */
	public boolean checkTitle(Product prod) {

		boolean isNeeded = false;

		// Splits the product title into an array of strings
		String[] parsedTitle = prod.getTitle().replace(" ", "").split(" ");

		// checks if the word keyboard or computer appears
		String k = "keyboard";
		String c = "computer";

		for (String keyWord : parsedTitle) {

			if (keyWord.equals(k) || keyWord.equals(c)) {
				isNeeded = true;
			} else {
				isNeeded = false;
			}

		}
		return isNeeded;
	}

	public boolean checkDuplicate(Product prod) {
		
		boolean isDuplicate = false;
		
		for (Product product : shoppingCart) {
			if (product.getTitle().equals(prod.getTitle())) {
				isDuplicate = true;
			} else {
				isDuplicate = false;
			}
		}
		return isDuplicate;
	}
	
}
