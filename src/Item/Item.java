package Item;

import Person.User;

public class Item {
    private static int index= 0;
    private String name;
    private int estimatedPrice;
    private User owner;
    private Boolean available;

    public Item(String name, int estimatedPrice, User owner) {
        this.name = name;
        this.estimatedPrice = estimatedPrice;
        this.owner = owner;
        this.available = true;
        this.index++;
    }

    public static int getIndex() {
        return index;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + " Price: " + this.estimatedPrice + " Owner email: " + this.owner.getEmail() + " Status: " + this.available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(int estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
