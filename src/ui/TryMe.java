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
    private ProductContainer pc;
    private CustomerContainer cc;
    private Product p1, p2, p3, p4, p5;
    private Customer c1, c2, c3, c4, c5;
    private Tool t1, t2, t3;
    private ToolCopy copy1, copy2, copy3, copy4, copy5, copy6;
	private ToolContainer tc;

    public TryMe() { 
        pc = ProductContainer.getInstance();
        
        p1 = new Product (12345, 10, "Hylde 1, række 1", 10, 11, 8, "Dette er en hammer", "hammer", 100, 10);
        	pc.addProduct(p1);
        
        p2 = new Product (22345, 10, "Hylde 1, række 2", 16, 11, 8, "Dette er en lille hammer", "hammer", 100, 10);
        	pc.addProduct(p2);
        
        p3 = new Product (32345, 10, "Hylde 1, række 3", 15, 11, 8, "Dette er en skruetrækker", "skruetrækker", 100, 10);
        	pc.addProduct(p3);
        
        p4 = new Product (42345, 10, "Hylde 1, række 4", 15, 11, 8, "Dette er et målebånd", "målebånd", 100, 10);
        	pc.addProduct(p4);
        
        p5 = new Product (52345, 10, "Hylde 1, række 5", 110, 11, 8, "Dette er en boremaskine", "boremaskine", 100, 10);
        	pc.addProduct(p5);
        
        
        cc = CustomerContainer.getInstance();
        
        c1 = new Customer ("Mikkel", "Karl Marx alle 87", "mikkel@hotmail.com", 22407778);
        	cc.addCustomerToContainer(c1);
        
        c2 = new Customer ("lars", "hjemme hos dig", "LarsErEnHyggefætter@gmail.com", 12345568);
        	cc.addCustomerToContainer(c2);
        
        c3 = new Customer ("Peter", "aalborg kongress", "peterkok@gmail.com", 49385135);
        	cc.addCustomerToContainer(c3);
        
        c4 = new Customer ("kasper", "hjemløs", "JegHaderKøbenhavn@gmail.com", 27561359);
        	cc.addCustomerToContainer(c4);
        
        c5 = new Customer ("Stefan", "Store Villavej", "LadMigVære@gmail.com", 14359768);
        	cc.addCustomerToContainer(c5);
        
        
        tc = ToolContainer.getInstance();
        
        t1 = new Tool (47, "flotte røde plæneklippere", 11111, "plæneklipper");
        	tc.addToolToToolContainer(t1);
        		copy1 = new ToolCopy ();
        		copy2 = new ToolCopy ();
        			t1.addCopyToTool(copy1);
        			t1.addCopyToTool(copy2);
        
        t2 = new Tool (4, "store sorte skruetrækkere", 22222, "skruetrækker");
        	tc.addToolToToolContainer(t2);
        		copy3 = new ToolCopy ();
        		copy4 = new ToolCopy ();
        			t2.addCopyToTool(copy3);
        			t2.addCopyToTool(copy4);
        
        t3 = new Tool (23, "små gule motorsave", 33333, "motorsav");
        	tc.addToolToToolContainer(t3);
        		copy5 = new ToolCopy ();
        		copy6 = new ToolCopy ();
        			t3.addCopyToTool(copy5);
        			t3.addCopyToTool(copy6);
 
    }

    public static void main(String[] args) {
        TryMe tryMe = new TryMe();	

       
       

       
        tryMe.p1.getCurrentPrice();
        tryMe.p3.getPurchasePrice();
        tryMe.p5.getBasePrice();
        
        tryMe.p1.getCurrentPrice(LocalDate.now());
        tryMe.p3.getPurchasePrice(LocalDate.now());
        tryMe.p5.getBasePrice(LocalDate.now());
        
      
    }

}