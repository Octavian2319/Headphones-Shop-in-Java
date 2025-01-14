import java.util.ArrayList;
import java.util.List;

/**
 * Clasa ShoppingCart gestionează produsele adăugate în coșul de cumpărături.
 */
public class ShoppingCart {
    private final List<Headphones> cart; // Lista de produse în coș

    public ShoppingCart() {
        cart = new ArrayList<>(); // Inițializează lista de produse
    }

    /**
     * Adaugă un produs în coș.
     * @param headphones Produsul de adăugat
     */
    public void addProduct(Headphones headphones) {
        cart.add(headphones);
    }

    /**
     * Elimină un produs din coș.
     * @param headphones Produsul de eliminat
     */
    public void removeProduct(Headphones headphones) {
        cart.remove(headphones);
    }

    /**
     * Calculează totalul prețurilor produselor din coș.
     * @return Totalul prețurilor
     */
    public double calculateTotal() {
        double total = 0;
        for (Headphones headphones : cart) {
            total += headphones.getPrice();
        }
        return total;
    }

    /**
     * Obține lista produselor din coș.
     * @return Lista produselor
     */
    public List<Headphones> getCartItems() {
        return cart;
    }
}
