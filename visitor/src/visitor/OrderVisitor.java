package visitor;

import java.util.Vector;

import orders.CaliforniaOrder;
import orders.ColombianOrder;
import orders.NonCaliforniaOrder;
import orders.OverseasOrder;
import orders.Order;

import orders.OrderComponent;
import iterator.AllOrders;

public class OrderVisitor extends OrderComponent implements VisitorInterface {
  private AllOrders orders;

  public OrderVisitor() {
    orders = new AllOrders();
  }

  @Override
  public void visit(NonCaliforniaOrder inp_order) {
    //orderTotal = orderTotal + inp_order.getOrderAmount();
    orders.addOrder(inp_order);
  }

  @Override
  public void visit(CaliforniaOrder inp_order) {
    //orderTotal = orderTotal + inp_order.getOrderAmount() + inp_order.getAdditionalTax();
    orders.addOrder(inp_order);
  }

  @Override
  public void visit(OverseasOrder inp_order) {
    //orderTotal = orderTotal + inp_order.getOrderAmount() + inp_order.getAdditionalSH();
    orders.addOrder(inp_order);
  }

  @Override
  public void visit(ColombianOrder inp_order) {
    //orderTotal = orderTotal + inp_order.getOrderAmount() + inp_order.getAdditionalSH();
    orders.addOrder(inp_order);
  }

  @Override
  public double getOrderTotal() {
    double orderTotal = 0.0;

    while(orders.hasNext()) {
      OrderComponent tempOrder = orders.next();
      orderTotal += tempOrder.getOrderTotal();
    }

    return orderTotal;
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
}
