package ui;
import model.Customer;
import model.CustomerContainer;
import model.Product;
import java.time.LocalDate;

import model.Tool;

import model.ProductContainer;
import model.ToolContainer;
import model.ToolCopy;
public class TryMe {
    private ProductContainer productContainer;
    private CustomerContainer customerContainer;
    private ToolContainer toolContainer;
    private Product product1, product2, product3, product4, product5;
    private Customer customer1, customer2, customer3, customer4, customer5;
    private Tool tool1, tool2, tool3;
    private ToolCopy copy1, copy2, copy3, copy4, copy5, copy6;
	

    public TryMe() { 
        productContainer = ProductContainer.getInstance();
        
        product1 = new Product (12345, 10, "Hylde 1, række 1", 10, 11, 8, "Dette er en hammer", "hammer", 100, 10);
        	productContainer.addProduct(product1);
        
        product2 = new Product (22345, 10, "Hylde 1, række 2", 16, 11, 8, "Dette er en lille hammer", "hammer", 100, 10);
        	productContainer.addProduct(product2);
        
        product3 = new Product (32345, 10, "Hylde 1, række 3", 15, 11, 8, "Dette er en skruetrækker", "skruetrækker", 100, 10);
        	productContainer.addProduct(product3);
        
        product4 = new Product (42345, 10, "Hylde 1, række 4", 15, 11, 8, "Dette er et målebånd", "målebånd", 100, 10);
        	productContainer.addProduct(product4);
        
        product5 = new Product (52345, 10, "Hylde 1, række 5", 110, 11, 8, "Dette er en boremaskine", "boremaskine", 100, 10);
        	productContainer.addProduct(product5);
        
        
        customerContainer = CustomerContainer.getInstance();
        
        customer1 = new Customer ("Mikkel", "Karl Marx alle 87", "mikkel@hotmail.com", 22407778);
        	customerContainer.addCustomerToContainer(customer1);
        
        customer2 = new Customer ("lars", "hjemme hos dig", "LarsErEnHyggefætter@gmail.com", 12345568);
        	customerContainer.addCustomerToContainer(customer2);
        
        customer3 = new Customer ("Peter", "aalborg kongress", "peterkok@gmail.com", 49385135);
        	customerContainer.addCustomerToContainer(customer3);
        
        customer4 = new Customer ("kasper", "hjemløs", "JegHaderKøbenhavn@gmail.com", 27561359);
        	customerContainer.addCustomerToContainer(customer4);
        
        customer5 = new Customer ("Stefan", "Store Villavej", "LadMigVære@gmail.com", 14359768);
        	customerContainer.addCustomerToContainer(customer5);
        
        
        toolContainer = ToolContainer.getInstance();
        
        tool1 = new Tool (47, "flotte røde plæneklippere", 11111, "plæneklipper");
        	toolContainer.addToolToToolContainer(tool1);
        		copy1 = new ToolCopy ();
        		copy2 = new ToolCopy ();
        			tool1.addCopyToTool(copy1);
        			tool1.addCopyToTool(copy2);
        
        tool2 = new Tool (4, "store sorte skruetrækkere", 22222, "skruetrækker");
        	toolContainer.addToolToToolContainer(tool2);
        		copy3 = new ToolCopy ();
        		copy4 = new ToolCopy ();
        			tool2.addCopyToTool(copy3);
        			tool2.addCopyToTool(copy4);
        
        tool3 = new Tool (23, "små gule motorsave", 33333, "motorsav");
        	toolContainer.addToolToToolContainer(tool3);
        		copy5 = new ToolCopy ();
        		copy6 = new ToolCopy ();
        			tool3.addCopyToTool(copy5);
        			tool3.addCopyToTool(copy6);
 
    }

    public static void main(String[] args) {
        TryMe tryMe = new TryMe();	
    }
}