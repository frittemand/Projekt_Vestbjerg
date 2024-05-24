package ui;
import model.Product;
import model.ProductContainer;
public class TryMe {
private ProductContainer pc;
public TryMe(){ 
pc = ProductContainer.getInstance();

Product p1 = new Product (12345,10,"Hylde 1, række 1",10,11,8,"Dette er en hammer","hammer",100,10 );
Product p2 = new Product (22345,10,"Hylde 1, række 2",16,11,8,"Dette er en lille hammer","hammer",100,10 );
Product p3 = new Product (32345,10,"Hylde 1, række 3",15,11,8,"Dette er en skruetrækker","skruetrækker",100,10 );
Product p4 = new Product (42345,10,"Hylde 1, række 4",15,11,8,"Dette er et målebånd","målebånd",100,10 );
Product p5 = new Product (52345,10,"Hylde 1, række 5",110,11,8,"Dette er en boremaskine","boremaskine",100,10 );

pc.addProduct(p1);
pc.addProduct(p2);
pc.addProduct(p3);
pc.addProduct(p4);
pc.addProduct(p5);

}
}

