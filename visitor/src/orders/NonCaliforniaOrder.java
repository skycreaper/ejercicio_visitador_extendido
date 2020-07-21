package orders;

import visitor.OrderVisitor;

public class NonCaliforniaOrder extends OrderComponent implements Order {

  private int id;
  private double orderAmount;

  public NonCaliforniaOrder() {}

  public NonCaliforniaOrder(int id, double inp_orderAmount) {
    this.id = id;
    orderAmount = inp_orderAmount;
  }

  public int getId() {
    return this.id;
  }

  public double getOrderAmount() {
    return orderAmount;
  }

  public void accept(OrderVisitor v) {
    v.visit(this);
  }

  @Override
  public double getOrderTotal() {
    return this.orderAmount;
  }
}
