package visitor;

import java.time.LocalDateTime;
import java.util.Vector;

import orders.CaliforniaOrder;
import orders.ColombianOrder;
import orders.NonCaliforniaOrder;
import orders.OverseasOrder;

import orders.OrderComponent;
import iterator.AllOrders;

public class OrderVisitor extends OrderComponent implements VisitorInterface {

  private AllOrders orders;
  private double orderTotal;

  public OrderVisitor() {
    orders = new AllOrders();
  }

  @Override
  public void visit(NonCaliforniaOrder inp_order) {
    orders.addOrder(inp_order);
  }

  @Override
  public void visit(CaliforniaOrder inp_order) {
    orders.addOrder(inp_order);
  }

  @Override
  public void visit(OverseasOrder inp_order) {
    orders.addOrder(inp_order);
  }

  @Override
  public void visit(ColombianOrder inp_order) {
    orders.addOrder(inp_order);
  }

  @Override
  public double getOrderTotal() {
    return orderTotal;
  }

  public Vector<OrderComponent> getAllOrdersData() {
    orderTotal = 0.0;
    Vector<OrderComponent> data = new Vector<OrderComponent>();
    while (orders.hasNext()) {
      OrderComponent tempOrder = orders.next();
      orderTotal += tempOrder.getOrderTotal();
        /*String[] row = {
          Integer.toString(tempOrder.getId()),
          Double.toString(tempOrder.getOrderTotal()),
          tempOrder.getCreatedTime().toString()
      };*/
      data.add(tempOrder);
    }
    return data;
  }

  /**
   * Corrige los valores de una orden
   */
  public String editOrder(OrderComponent order) {
    String message = "Order updated";
    try {
      this.orders.update(order.getId(), order);
    } catch (Exception e) {
      message = "Order couldn't be updated";
    }
    return message;
  }

  @Override
  public LocalDateTime getCreatedTime() {
    // TODO Auto-generated method stub
    return null;
  }
}
