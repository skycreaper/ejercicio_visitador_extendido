public class DirectorUI {
    private OrderBuilder builderUI;

    public DirectorUI (OrderBuilder bldr) {
        builderUI = bldr;
    }
    public void build () {
        builderUI.addUIComponent();
    }
}
