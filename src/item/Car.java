package item;

import person.User;

public class Car extends Item{
    private String fuel;
    private int mileage;
    private int manufacturingYear;

    public Car(String name, int estimatedPrice, User owner, String fuel, int mileage, int manufacturingYear) {
        super(name, estimatedPrice, owner);
        this.fuel = fuel;
        this.mileage = mileage;
        this.manufacturingYear = manufacturingYear;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }
}
