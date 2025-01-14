/**
 * Fabrica CasualHeadphonesFactory creează instanțe de căști casual.
 */
public class CasualHeadphonesFactory {
    public static Headphones createCasualHeadphones(String material, String feature, String brand) {
        double price = 100.0 + (Math.random() * 25); // Preț aleator între 100 și 125
        int rating = 3 + (int) (Math.random() * 2); // Rating între 3 și 5
        return new CasualHeadphones(material, feature, brand, price, rating);
    }
}
