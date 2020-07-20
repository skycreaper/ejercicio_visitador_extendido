package visitor;

import orders.CaliforniaOrder;
import orders.ColombianOrder;
import orders.NonCaliforniaOrder;
import orders.OverseasOrder;

public interface VisitorInterface {
  public void visit(NonCaliforniaOrder nco);
  public void visit(CaliforniaOrder co);
  public void visit(OverseasOrder oo);
  public void visit(ColombianOrder copOrder);
}
