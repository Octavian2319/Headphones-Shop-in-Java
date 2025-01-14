import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HeadphonesGUI {
    private JFrame frame; // Fereastra principală
    private JTable table; // Tabelul pentru afișarea produselor
    private DefaultTableModel tableModel; // Modelul tabelului pentru gestionarea rândurilor
    private ShoppingCart cart; // Obiect pentru gestionarea coșului de cumpărături

    public HeadphonesGUI() {
        cart = new ShoppingCart(); // Inițializează coșul de cumpărături
    }

    public void display() {
        // Creează fereastra principală
        frame = new JFrame("Headphones Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Definește coloanele tabelului
        String[] columns = {"Type", "Material", "Feature", "Brand", "Price", "Rating"};
        tableModel = new DefaultTableModel(columns, 0); // Modelul pentru tabel
        table = new JTable(tableModel); // Creează tabelul cu modelul
        JScrollPane scrollPane = new JScrollPane(table); // Adaugă un scroll pentru tabel

        // ComboBox-uri pentru selectarea opțiunilor de căști
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Gaming", "Studio", "Casual"});
        JComboBox<String> materialComboBox = new JComboBox<>(new String[]{"Plastic", "Metal", "Wood", "Carbon"});
        JComboBox<String> featureComboBox = new JComboBox<>(new String[]{"Bluetooth", "Noise Cancelling", "Surround"});

        // ComboBox pentru selectarea brandului (dinamic, în funcție de tipul de căști)
        JComboBox<String> brandComboBox = new JComboBox<>(new String[]{"First select a type"});
        typeComboBox.addActionListener(e -> updateBrandOptions(typeComboBox, brandComboBox)); // Actualizează lista de branduri

        // Buton pentru adăugarea produsului selectat în tabel și în coș
        JButton addButton = new JButton("Add to Cart");
        addButton.addActionListener(e -> addProductToTable(typeComboBox, materialComboBox, featureComboBox, brandComboBox));

        // Buton pentru afișarea totalului din coș
        JButton viewCartButton = new JButton("View Cart");
        viewCartButton.addActionListener(e -> viewCart());

        // Panou pentru plasarea elementelor de interfață
        JPanel panel = new JPanel();
        panel.add(new JLabel("Type:"));
        panel.add(typeComboBox);
        panel.add(new JLabel("Material:"));
        panel.add(materialComboBox);
        panel.add(new JLabel("Feature:"));
        panel.add(featureComboBox);
        panel.add(new JLabel("Brand:"));
        panel.add(brandComboBox);
        panel.add(addButton);
        panel.add(viewCartButton);

        // Adaugă panoul de selecții sus și tabelul în centru
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true); // Afișează fereastra
    }

    /**
     * Actualizează opțiunile de branduri în funcție de tipul de căști selectat.
     */
    private void updateBrandOptions(JComboBox<String> typeComboBox, JComboBox<String> brandComboBox) {
        String type = (String) typeComboBox.getSelectedItem(); // Obține tipul selectat

        brandComboBox.removeAllItems(); // Golește lista de branduri existente

        // Adaugă branduri specifice pentru fiecare tip
        if ("Gaming".equals(type)) {
            brandComboBox.addItem("HyperX");
            brandComboBox.addItem("Razer");
            brandComboBox.addItem("SteelSeries");
        } else if ("Studio".equals(type)) {
            brandComboBox.addItem("Bose");
            brandComboBox.addItem("Sennheiser");
            brandComboBox.addItem("Audio-Technica");
        } else if ("Casual".equals(type)) {
            brandComboBox.addItem("Sony");
            brandComboBox.addItem("JBL");
            brandComboBox.addItem("Beats");
        }
    }

    /**
     * Adaugă produsul selectat în tabel și în coșul de cumpărături.
     */
    private void addProductToTable(JComboBox<String> typeComboBox, JComboBox<String> materialComboBox, JComboBox<String> featureComboBox, JComboBox<String> brandComboBox) {
        String type = (String) typeComboBox.getSelectedItem(); // Tipul de căști
        String material = (String) materialComboBox.getSelectedItem(); // Materialul selectat
        String feature = (String) featureComboBox.getSelectedItem(); // Caracteristica selectată
        String brand = (String) brandComboBox.getSelectedItem(); // Brandul selectat

        // Verifică dacă utilizatorul a selectat un brand
        if (brand == null || brand.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please select a brand.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Creează un obiect Headphones folosind fabricile corespunzătoare
        Headphones headphones;
        if ("Gaming".equals(type)) {
            headphones = GamingHeadphonesFactory.createGamingHeadphones(material, feature, brand);
        } else if ("Studio".equals(type)) {
            headphones = StudioHeadphonesFactory.createStudioHeadphones(material, feature, brand);
        } else {
            headphones = CasualHeadphonesFactory.createCasualHeadphones(material, feature, brand);
        }

        // Adaugă produsul în coș
        cart.addProduct(headphones);

        // Adaugă produsul în tabel
        tableModel.addRow(new Object[]{type, material, feature, brand, String.format("%.2f", headphones.getPrice()), headphones.getRating()});
    }

    /**
     * Afișează totalul produselor din coș într-un dialog.
     */
    private void viewCart() {
        double total = cart.calculateTotal(); // Calculează totalul
        JOptionPane.showMessageDialog(frame,
                String.format("Total price: $%.2f", total), // Afișează totalul formatat
                "Cart Summary",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Metoda principală pentru a lansa aplicația.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HeadphonesGUI().display()); // Rulează interfața grafică
    }
}
