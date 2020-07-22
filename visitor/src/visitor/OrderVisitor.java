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
  Vector<OrderComponent> data;

  public OrderVisitor() {
    data = new Vector<>();
  }

  @Override
  public void visit(NonCaliforniaOrder inp_order) {
    data.add(inp_order);
  }

  @Override
  public void visit(CaliforniaOrder inp_order) {
    data.add(inp_order);
  }

  @Override
  public void visit(OverseasOrder inp_order) {
    data.add(inp_order);
  }

  @Override
  public void visit(ColombianOrder inp_order) {
    data.add(inp_order);
  }

  @Override
  public void setOrderAmount(double dblAmount) {
  }

  @Override
  public void setAdditionalTax(double dblTax) {
  }

  @Override
  public double getOrderTotal() {
    return orderTotal;
  }

  public Vector<OrderComponent> getAllOrdersData() {
    orderTotal = 0.0;
    orders = new AllOrders(this.data);
    while (orders.hasNext()) {
      OrderComponent tempOrder = orders.next();
      orderTotal += tempOrder.getOrderTotal();
    }
    return this.data;
  }

  /**
   * Corrige los valores de una orden
   */
  public String editOrder(OrderComponent order) {
    String message = "Order updated";
    try {
      this.orders.updateOrder(order.getId(), order);
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
  public OrderComponent getOrderSimple(int idOrden) throws Exception {
    return orders.getOrder(idOrden);
  }
}
