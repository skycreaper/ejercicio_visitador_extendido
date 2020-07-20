package composite;

public class OverseasOrder implements OrderComponent {

  private double orderAmount;
  private double additionalSH;

  public OverseasOrder() { }

  public OverseasOrder(double inp_orderAmount, double inp_additionalSH) {
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
  }

  public double getOrderAmount() {

    return orderAmount;
  }

  public double getAdditionalSH() {
    return additionalSH;
  }

  @Override
  public double getOrderTotal() {
    return getOrderAmount() + getAdditionalSH();
  }
}
