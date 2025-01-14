/**
 * Interfața AbstractFactory definește metode pentru crearea diferitelor tipuri de căști.
 */
public interface AbstractFactory {
    AbstractProductA createOverEarHeadphones(String material, String feature, String brand);
    AbstractProductB createInEarHeadphones(String material, String feature, String brand);
}
