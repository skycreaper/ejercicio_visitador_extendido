package orders;

import visitor.OrderVisitor;

public class OverseasOrder extends OrderComponent implements Order {

  private int id;
  private double orderAmount;
  private double additionalSH;

  public OverseasOrder() { }

  public OverseasOrder(int id, double inp_orderAmount, double inp_additionalSH) {
    this.id = id;
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
  }

  public int getId() {
    return this.id;
  }

  public double getOrderAmount() {
    return orderAmount;
  }

  public double getAdditionalSH() {
    return additionalSH;
  }

  public void accept(OrderVisitor v) {
    v.visit(this);
  }

  @Override
  public double getOrderTotal() {
    return this.orderAmount + this.additionalSH;
  }
}
