package composite;

import java.util.Iterator;
import java.util.Vector;

public class OrderComposite implements OrderComponent {
    Vector<OrderComponent> allOrders;

    public OrderComposite() {
        allOrders = new Vector();
    }

    @Override
    public double getOrderTotal() {
        // aquí se recorre todo el iterator
        return 0;
    }
    
}