package orders;

import java.time.LocalDateTime;

public abstract class OrderComponent {
    
    public int getId() throws Exception {
        throw new Exception("No id ");
    }

    public String getTypeName() {
        return ("No type");
    }

    public double getAdditionalSH() {
        return 0.0;
    }

    public double getAdditionalTax() {
        return 0.0;
    }

    public double getOrderAmount() {
        return 0.0;
    }

    public abstract double getOrderTotal();
    public abstract LocalDateTime getCreatedTime();
    
}