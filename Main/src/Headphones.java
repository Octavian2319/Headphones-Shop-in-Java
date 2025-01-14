/**
 * Clasa abstractă Headphones reprezintă baza pentru toate tipurile de căști.
 */
public abstract class Headphones {
    private final String material; // Materialul căștilor
    private final String feature; // Caracteristica specială
    private final String brand; // Brandul
    private final double price; // Prețul
    private final int rating; // Rating-ul

    public Headphones(String material, String feature, String brand, double price, int rating) {
        this.material = material;
        this.feature = feature;
        this.brand = brand;
        this.price = price;
        this.rating = rating;
    }

    public String getMaterial() {
        return material;
    }

    public String getFeature() {
        return feature;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public abstract void displayDetails(); // Metodă abstractă pentru afișarea detaliilor
}
