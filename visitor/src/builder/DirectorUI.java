package builder;

public class DirectorUI {
    private OrderBuilder builderUI;

    public DirectorUI (OrderBuilder bldr) {
        builderUI = bldr;
    }
    public void build () {
        builderUI.addUIComponent();
    }

    public void setValues(String amnt, String tax) {
        builderUI.setValuesFromOldOrders(amnt, tax);
    }
}
