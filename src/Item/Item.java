package Item;

import Person.User;

public class Item {
    private String name;
    private int estimatedPrice;
    private User owner;

    public Item(String name, int estimatedPrice, User owner) {
        this.name = name;
        this.estimatedPrice = estimatedPrice;
        this.owner = owner;
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
}
