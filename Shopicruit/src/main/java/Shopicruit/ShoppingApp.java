package Shopicruit;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;

public class ShoppingApp {

	public static void main(String[] args) {
		
		HashSet<Product> shopicruit = new HashSet<Product>();
		
		Path file = Paths.get("ShopicruitCatalog.txt");
		
		if (Files.exists(file)) {
			
			//read products from catalog
			try {
				BufferedReader reader = Files.newBufferedReader(file);
				
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
					String[] items = line.split(":");
					int ID = Integer.parseInt(items[1]);
					int price = Integer.parseInt(items[2]);
					int weightInGrams = Integer.parseInt(items[3]);
					Product product = new Product(items[0], ID, price, weightInGrams, items[4]);
					shopicruit.add(product);
				}
				
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Please connect to Shopicruit catalog.");
		}
		
		//create Shopicruit Store
		Store shopicruitStore = new Store();
		
		shopicruitStore.addToCart();
		shopicruitStore.checkCart();
		shopicruitStore.balanceProducts();
		shopicruitStore.buy();

	}

}
