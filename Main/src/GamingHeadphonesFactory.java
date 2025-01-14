/**
 * Fabrica GamingHeadphonesFactory creează instanțe de căști gaming.
 */
public class GamingHeadphonesFactory {
    public static Headphones createGamingHeadphones(String material, String feature, String brand) {
        double price = 150.0 + (Math.random() * 12); // Preț aleator între 150 și 162
        int rating = 3 + (int) (Math.random() * 3); // Rating între 3 și 5
        return new GamingHeadphones(material, feature, brand, price, rating);
    }
}
