package orders;

import java.time.LocalDateTime;

public abstract class OrderComponent {
    
    public int getId() throws Exception {
        throw new Exception("No id ");
    };

    public abstract double getOrderTotal();
    public abstract LocalDateTime getCreatedTime();
}