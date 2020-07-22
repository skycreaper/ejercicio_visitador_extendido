package orders;

import java.time.LocalDateTime;

public abstract class OrderComponent {
    
    public int getId() {
        return -1;
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
    public abstract void setOrderAmount(double dblAmount);
    public abstract void setAdditionalTax(double dblTax);


    public abstract double getOrderTotal();
    public abstract LocalDateTime getCreatedTime();
    
}