/**
 * Clasa StudioHeadphones definește căști specializate pentru studio.
 */
public class StudioHeadphones extends Headphones {
    public StudioHeadphones(String material, String feature, String brand, double price, int rating) {
        super(material, feature, brand, price, rating); // Apelează constructorul de bază
    }

    @Override
    public void displayDetails() {
        System.out.println("Studio Headphones: " + getBrand() + ", " + getMaterial() +
                ", Feature: " + getFeature() + ", Price: $" + String.format("%.2f", getPrice()) +
                ", Rating: " + getRating());
    }
}
