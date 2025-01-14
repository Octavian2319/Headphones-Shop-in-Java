/**
 * Clasa CasualHeadphones definește căști casual.
 */
public class CasualHeadphones extends Headphones {
    public CasualHeadphones(String material, String feature, String brand, double price, int rating) {
        super(material, feature, brand, price, rating); // Apelează constructorul de bază
    }

    @Override
    public void displayDetails() {
        System.out.println("Casual Headphones: " + getBrand() + ", " + getMaterial() +
                ", Feature: " + getFeature() + ", Price: $" + String.format("%.2f", getPrice()) +
                ", Rating: " + getRating());
    }
}
