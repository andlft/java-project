import Auction.Auction;
import Bid.Bid;
import Building.Building;
import Item.Item;
import Item.House;
import Item.Car;
import Person.Employee;
import Person.User;

import java.util.*;

public class Service {
    private List<Auction> auctions = new ArrayList<>();
    private List<Bid> bids = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<Building> buildings = new ArrayList<>();
    private HashMap<Integer, Employee> employees = new HashMap<>();
    private HashMap<Integer, User> users = new HashMap<>();

    public void addAuction(Auction auction){
        auctions.add(auction);
    }
    public void addBid (Bid bid){
        bids.add(bid);
        Collections.sort(bids, new Comparator<Bid>() {
            @Override
            public int compare(Bid o1, Bid o2) {
                if (o1.getSum() > o2.getSum()){
                    return 1;
                } else if (o1.getSum() < o2.getSum()) {
                    return -1;
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
        System.out.println(users);
    }
    public void addItem (Item item){
        items.add(item);
    }
    public void addHouse (House house){
        items.add(house);
    }
    public void addCar (Car car){
        items.add(car);
    }
    public void addBuilding (Building building){buildings.add(building);}
    public void showAllItems (){
        for (Item it:items){
            System.out.println(it);
        }
    }
    public void showAllCars (){
        for (Item it:items){
            try {
                Car c =  (Car) it;
                System.out.println(it);
            }
            catch (Exception e){
                continue;
            }
        }
    }
    public void showAllHouses (){
        for (Item it:items){
            try {
                House c =  (House) it;
                System.out.println(it);
            }
            catch (Exception e){
                continue;
            }
        }
    }

    public User getUserById (Integer id){
        try {
            return users.get(id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return  new User("Popescu", "Ion", "0234", "13243");
        }
    }


}
