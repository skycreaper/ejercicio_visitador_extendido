package visitor;

import orders.CaliforniaOrder;
import orders.ColombianOrder;
import orders.NonCaliforniaOrder;
import orders.OverseasOrder;

public class FixOrderVisitor implements VisitorInterface {

    @Override
    public void visit(NonCaliforniaOrder nco) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(CaliforniaOrder co) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(OverseasOrder oo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(ColombianOrder copOrder) {
        // TODO Auto-generated method stub

    }
    
}