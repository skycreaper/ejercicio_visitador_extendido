package iterator;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

import orders.OrderComponent;

public class AllOrders implements Iterator<OrderComponent> {

    Vector<OrderComponent> orderColl; // Colección de ordenes
    Enumeration<OrderComponent> enumerationOrders;
    OrderComponent nextOrder;

    public AllOrders(Vector<OrderComponent> data) {
        this.orderColl = data;
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

    /**
     * Updates an order using the id
     * @param orderId: the id of the order
     * @param newOrder: the new order that will be replacing the old order
     */
    public void updateOrder(int orderId, OrderComponent newOrder) throws Exception {
        for (int i = 0; i < this.orderColl.size(); i++) {
            if (this.orderColl.get(i).getId() == orderId) {
                this.orderColl.set(i, newOrder);
                break;
            }
        }
    }

    public OrderComponent getOrder(int orderId) throws Exception {
        OrderComponent oComp = null;
        try {
            for (int i = 0; i < this.orderColl.size(); i++) {
                if (this.orderColl.get(i).getId() == orderId) {
                    oComp = orderColl.get(i);
                    break;
                }
            }
        } catch (Exception e){
        }
        return oComp;
    }
    /*
    se necesita retornar los valores de amount y tax
     */
}