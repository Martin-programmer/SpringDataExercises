package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle {
    @Column(name = "load_capacity")
    private double loadCapacity;

    public Truck(){}

    public Truck(String model, BigDecimal price, String fuelType, double loadCapacity) {
        super(model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }

    public Truck(Long id, String type, String model, BigDecimal price, String fuelType, double loadCapacity) {
        super(id, type, model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Truck{");
        sb.append(super.toString());
        sb.append("loadCapacity=").append(loadCapacity);
        sb.append('}');
        return sb.toString();
    }
}
