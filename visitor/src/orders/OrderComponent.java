package orders;

public abstract class OrderComponent {
    
    public int getId() throws Exception {
        throw new Exception("No id ");
    };

    public abstract double getOrderTotal();
}