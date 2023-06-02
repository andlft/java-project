package person;

import item.Item;

import java.util.ArrayList;
import java.util.List;

public class User extends Person{
    public static int index = 0;
    private List<Item> wishList = new ArrayList<>();

    public User(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
        index ++;
    }

    public static int getIndex() {
        return index;
    }

    public List<Item> getWishList() {
        return wishList;
    }

    public void setWishList(List<Item> wishList) {
        this.wishList = wishList;
    }
    public void addItemToWishList (Item item){
        wishList.add(item);
    }
}
