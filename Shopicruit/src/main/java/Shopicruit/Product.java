package Shopicruit;

/**
 * @author Sun
 *
 */
public class Product implements Comparable {

	private String title;
	private int ID;
	private int price;
	private int weightInGrams;
	private String variants;
	
	public Product(String title, int iD, int price, int weightInGrams, String variants) {
		super();
		this.title = title;
		ID = iD;
		this.price = price;
		this.weightInGrams = weightInGrams;
		this.variants = variants;
	}

	public String getTitle() {
		return title;
	}

	public int getID() {
		return ID;
	}

	public int getPrice() {
		return price;
	}

	public int getWeightInGrams() {
		return weightInGrams;
	}

	public String getVariants() {
		return variants;
	}

	@Override
	public int compareTo(Product comparesTo) {
		int comparePrice = comparesTo.getPrice();
		return this.price-comparePrice;
	}
	
}
