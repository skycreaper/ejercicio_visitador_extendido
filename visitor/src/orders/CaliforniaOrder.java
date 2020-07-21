package orders;

import java.time.LocalDateTime;

import visitor.OrderVisitor;

public class CaliforniaOrder extends OrderComponent implements Order {

  private int id;
  private LocalDateTime createdTime;
  private double orderAmount;
  private double additionalTax;

  public CaliforniaOrder(int id, double inp_orderAmount, double inp_additionalTax) {
    this.id = id;
    this.createdTime = LocalDateTime.now();
    orderAmount = inp_orderAmount;
    additionalTax = inp_additionalTax;
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public LocalDateTime getCreatedTime() {
    return this.createdTime;
  }

  public double getOrderAmount() {
    return orderAmount;
  }

  public double getAdditionalTax() {
    return additionalTax;
  }

  public void accept(OrderVisitor v) {
    v.visit(this);
  }

  @Override
  public double getOrderTotal() {
    return this.orderAmount + this.additionalTax;
  }
}

