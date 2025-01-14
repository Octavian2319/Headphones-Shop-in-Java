/**
 * Clasa GamingHeadphones definește căști specializate pentru gaming.
 */
public class GamingHeadphones extends Headphones {
    public GamingHeadphones(String material, String feature, String brand, double price, int rating) {
        super(material, feature, brand, price, rating); // Apelează constructorul de bază
    }

    @Override
    public void displayDetails() {
        System.out.println("Gaming Headphones: " + getBrand() + ", " + getMaterial() +
                ", Feature: " + getFeature() + ", Price: $" + String.format("%.2f", getPrice()) +
                ", Rating: " + getRating());
    }
}
