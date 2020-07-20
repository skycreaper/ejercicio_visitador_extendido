package iterator;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

import orders.OrderComponent;

public class AllOrders implements Iterator {

    Vector<OrderComponent> orderColl; // Colección de ordenes
    Enumeration<OrderComponent> enumerationOrders;
    OrderComponent nextOrder;


    public AllOrders() {
        this.orderColl = new Vector<OrderComponent>();
    }

    public void addOrder(OrderComponent order) {
        orderColl.add(order);
        enumerationOrders = orderColl.elements();
    }

    @Override
    public boolean hasNext() {
        boolean matchFound = false;
        nextOrder = null;

        while (enumerationOrders.hasMoreElements()) {
            OrderComponent tempOrder = (OrderComponent) enumerationOrders.nextElement();
            nextOrder = tempOrder;
            break;
        }

        if (nextOrder != null) {
            matchFound = true;
        }

        return matchFound;
    }

    @Override
    public OrderComponent next() {
        if (nextOrder == null) {
            throw new NoSuchElementException();
        } else {
            return nextOrder;
        }
    }

    public void add(Object order) {
        
    }
    
}