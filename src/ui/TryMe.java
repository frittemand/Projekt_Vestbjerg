package ui;
import model.Product;
import model.ProductContainer;
import java.time.LocalTime;
import java.util.Stack;
public class TryMe {
    private ProductContainer pc;
    private Product p1, p2, p3, p4, p5;

    public TryMe() { 
        pc = ProductContainer.getInstance();
        
        p1 = new Product (12345, 10, "Hylde 1, række 1", 10, 11, 8, "Dette er en hammer", "hammer", 100, 10);
        p2 = new Product (22345, 10, "Hylde 1, række 2", 16, 11, 8, "Dette er en lille hammer", "hammer", 100, 10);
        p3 = new Product (32345, 10, "Hylde 1, række 3", 15, 11, 8, "Dette er en skruetrækker", "skruetrækker", 100, 10);
        p4 = new Product (42345, 10, "Hylde 1, række 4", 15, 11, 8, "Dette er et målebånd", "målebånd", 100, 10);
        p5 = new Product (52345, 10, "Hylde 1, række 5", 110, 11, 8, "Dette er en boremaskine", "boremaskine", 100, 10);
    }

    public static void main(String[] args) {
        TryMe tryMe = new TryMe();

        // Accessing pc using an instance of TryMe
        tryMe.pc.addProduct(tryMe.p1);
        tryMe.pc.addProduct(tryMe.p2);
        tryMe.pc.addProduct(tryMe.p3);
        tryMe.pc.addProduct(tryMe.p4);
        tryMe.pc.addProduct(tryMe.p5);

        // Accessing product methods
        tryMe.p1.getCurrentPrice();
        tryMe.p3.getPurchasePrice();
        tryMe.p5.getBasePrice();
        
        tryMe.p1.getCurrentPrice(LocalTime.now());
        tryMe.p3.getPurchasePrice(LocalTime.now());
        tryMe.p5.getBasePrice(LocalTime.now());
    }
 
}