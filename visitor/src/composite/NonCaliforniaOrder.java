package composite;

public class NonCaliforniaOrder implements OrderComponent{
  
  private double orderAmount;

  public NonCaliforniaOrder() {
  }
  public NonCaliforniaOrder(double inp_orderAmount) {
    orderAmount = inp_orderAmount;
  }
  public double getOrderAmount() {
    return orderAmount;
  }

  @Override
  public double getOrderTotal() {
    return getOrderAmount();
  }

}
