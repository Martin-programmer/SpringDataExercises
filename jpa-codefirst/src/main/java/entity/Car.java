package entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class Car extends Vehicle{
    @Column(name = "seats")
    private int seats;
    @OneToOne(mappedBy = "car")
    private PlateNumber plateNumber;

    public Car(){}

    public Car(String model, BigDecimal price, String fuelType, int seats) {
        super(model, price, fuelType);
        this.seats = seats;
    }

    public Car(Long id, String type, String model, BigDecimal price, String fuelType, int seats) {
        super(id, type, model, price, fuelType);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public PlateNumber getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(PlateNumber plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append(super.toString());
        sb.append("seats=").append(seats);
        sb.append(", plateNumber=").append(plateNumber);
        sb.append('}');
        return sb.toString();
    }
}
