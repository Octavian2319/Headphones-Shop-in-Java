/**
 * Fabrica StudioHeadphonesFactory creează instanțe de căști pentru studio.
 */
public class StudioHeadphonesFactory {

    /**
     * Creează o pereche de căști studio cu detalii specificate.
     * @param material Materialul căștilor (ex: Plastic, Metal, Lemn)
     * @param feature Caracteristica specială (ex: Bluetooth, Noise Cancelling)
     * @param brand Brandul căștilor (ex: Bose, Sennheiser)
     * @return O instanță de StudioHeadphones
     */
    public static Headphones createStudioHeadphones(String material, String feature, String brand) {
        double price = 200.0 + (Math.random() * 10); // Preț între 200 și 210
        int rating = 4 + (int) (Math.random() * 2); // Rating între 4 și 5
        return new StudioHeadphones(material, feature, brand, price, rating);
    }
}
