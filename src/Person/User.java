package Person;

import Item.Item;

import java.util.List;

public class User extends Person{
    private List<Item> wishList;

    public User(String firstName, String lastName, String phoneNumber, String email, List<Item> wishList) {
        super(firstName, lastName, phoneNumber, email);
        this.wishList = wishList;
    }

    public List<Item> getWishList() {
        return wishList;
    }

    public void setWishList(List<Item> wishList) {
        this.wishList = wishList;
    }
}
