package Building;

public class Building {
    private static int index= 0;
    private String name;
    private String address;
    private int surface;
    private int maxPeople;

    public Building(String name, String address, int surface, int maxPeople) {
        this.name = name;
        this.address = address;
        this.surface = surface;
        this.maxPeople = maxPeople;
        this.index ++;
    }

    public static int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getSurface() {
        return surface;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String toString() {return "Name: " + this.name + " Address: " + this.address;}
}
