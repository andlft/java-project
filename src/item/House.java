package item;

import person.User;

public class House extends Item{
    private int surface;
    private String address;

    public House(String name, int estimatedPrice, User owner, int surface, String address) {
        super(name, estimatedPrice, owner);
        this.surface = surface;
        this.address = address;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
