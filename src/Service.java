import Auction.Auction;
import Bid.Bid;
import Building.Building;
import Exceptions.LowerBid;
import Exceptions.NoItems;
import Item.Item;
import Item.House;
import Item.Car;
import Person.Employee;
import Person.User;

import java.util.*;

public class Service {
    private HashMap<Integer, Auction> auctions = new HashMap<Integer, Auction>();
    private List<Bid> bids = new ArrayList<>();
    private HashMap<Integer, Item> items = new HashMap<>();
    private HashMap<Integer, Building> buildings = new HashMap<>();
    private HashMap<Integer, Employee> employees = new HashMap<>();
    private HashMap<Integer, User> users = new HashMap<>();

    public void addAuction(Auction auction){
        auctions.put(auction.getIndex(), auction);
    }
    public void addBid (Bid bid) throws LowerBid {
        if (bid.getItem().getAvailable() == false){
            System.out.println("Item already sold!");
            return;
        }
        int i = bids.size() - 1;
        while (i >= 0){
            if ((bids.get(i).getItem()).equals(bid.getItem())) {
                if (bids.get(i).getSum() > bid.getSum()) {
                    throw new LowerBid("You have to bid higher than the last bid!", 333);
                }
            }
            i--;
        }
        bids.add(bid);
        Collections.sort(bids, new Comparator<Bid>() {
            @Override
            public int compare(Bid o1, Bid o2) {
                if (o1.getSum() > o2.getSum()){
                    return -1;
                } else if (o1.getSum() < o2.getSum()) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });
    }
    public void addEmployee (Employee employee){
        employees.put(employee.getIndex(), employee);
    }
    public void addUser (User user){
        users.put(user.getIndex(), user);
    }
    public void addItem (Item item){
        items.put(item.getIndex(), item);
    }
    public void setItemAsSoldById (Integer id){
        Item item = items.get(id);
        item.setAvailable(false);
    }
    public void addBuilding (Building building){buildings.put(building.getIndex(), building);}


    public void showAllItems () throws NoItems{
        if (items.size() == 0){
            throw new  NoItems("There are no items to sell!", 555);
        }
        items.forEach(
                (key, value) -> System.out.println(key + " : " + value)
        );
    }
    public void showAllCars (){
        for (Integer it:items.keySet() ){
            if (items.get(it) instanceof Car) {
                Car c = (Car) items.get(it);
                System.out.println(it + " : " + c);
            }
        }
    }
    public void showAllHouses (){
        for (Integer it:items.keySet() ){
            if (items.get(it) instanceof House) {
                House h = (House) items.get(it);
                System.out.println(it + " : " + h);
            }
        }
    }
    public void showAllBids(){
        for (Bid b : bids){
            System.out.println(b);
        }
    }
    public void showAllBuildings(){
        for (Integer it:buildings.keySet() ){
            Building b = buildings.get(it);
            System.out.println(it + " : " + b);
        }
    }
    public void showAllUsers(){
        for (Integer it:users.keySet() ){
            User u = users.get(it);
            System.out.println(it + " : " + u);
        }
    }
    public void showAllEmployees(){
        for (Integer it:employees.keySet() ){
            Employee e = employees.get(it);
            System.out.println(it + " : " + e);
        }
    }
    public void showAllAuctions(){
        for (Integer it:auctions.keySet() ){
            Auction a = auctions.get(it);
            System.out.println(it + " : " + a);
        }
    }
    public void showAllItemsAtAuction(Integer id){
        for (Integer it: auctions.get(id).getAuctionedItems() ){
            System.out.println(it + " : " + items.get(it));
        }
    }


    public User getUserById (Integer id){
        try {
            return users.get(id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }
    }
    public Auction getAuctionById (Integer id){
        try {
            return auctions.get(id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }
    }

    public Employee getEmployeeById (Integer id){
        try {
            return employees.get(id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }
    }

    public Item getItemById (Integer id){
        try {
            return items.get(id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }
    }

    public Building getBuildingById (Integer id){
        try {
            return buildings.get(id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }
    }


}
