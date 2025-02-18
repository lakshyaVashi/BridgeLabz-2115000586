import java.util.ArrayList;
import java.util.List;

abstract class Product<T> {
    private String name;
    private double price;
    private T category;
    
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public T getCategory() {
        return category;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + name + ", Price: " + price + ", Category: " + category;
    }
}

class BookCategory {}
class ClothingCategory {}
class GadgetCategory {}

class Book extends Product<BookCategory> {
    public Book(String name, double price, BookCategory category) {
        super(name, price, category);
    }
}

class Clothing extends Product<ClothingCategory> {
    public Clothing(String name, double price, ClothingCategory category) {
        super(name, price, category);
    }
}

class Gadget extends Product<GadgetCategory> {
    public Gadget(String name, double price, GadgetCategory category) {
        super(name, price, category);
    }
}

class Marketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
    }
    
    public static void displayProducts(List<? extends Product<?>> products) {
        for (Product<?> product : products) {
            System.out.println(product);
        }
    }
}

public class DynamicMarketplace {
    public static void main(String[] args) {
        List<Product<?>> catalog = new ArrayList<>();
        
        catalog.add(new Book("The Great Gatsby", 10.99, new BookCategory()));
        catalog.add(new Clothing("T-Shirt", 19.99, new ClothingCategory()));
        catalog.add(new Gadget("Smartphone", 299.99, new GadgetCategory()));
        
        System.out.println("Before Discount:");
        Marketplace.displayProducts(catalog);
        
        Marketplace.applyDiscount(catalog.get(0), 10);
        Marketplace.applyDiscount(catalog.get(1), 15);
        Marketplace.applyDiscount(catalog.get(2), 5);
        
        System.out.println("\nAfter Discount:");
        Marketplace.displayProducts(catalog);
    }
}
