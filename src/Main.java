import database.*;
import exceptions.LowerBidException;
import exceptions.NoItemsException;
import item.*;
import person.*;
import auction.*;
import building.*;
import bid.*;


import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Connection connection = MysqlConnection.getConnection();
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        Integer option = -1;
        while (option != 0){
            System.out.println("Choose an action type: \n" +
                    "1.Add a user\n" +
                    "2.Add an employee\n" +
                    "3.Add an item\n" +
                    "4.Add an building\n" +
                    "5.Add a auction\n" +
                    "6.Place a bid\n" +
                    "7.Show all items\n" +
                    "8.Show all houses\n" +
                    "9.Show all cars\n" +
                    "10.Mark an item as sold\n" +
                    "11.Database query\n" +
                    "0.Leave");

            option = Integer.parseInt(scanner.nextLine());
            if(option == 1){
                System.out.println("First name:");
                String firstName = scanner.nextLine();
                System.out.println("Last name:");
                String lastName =  scanner.nextLine();
                System.out.println("Phone number:");
                String phoneNumber = scanner.nextLine();
                System.out.println("Email: ");
                String email = scanner.nextLine();
                service.addUser(new User(firstName, lastName, phoneNumber, email));
            }

            if (option == 2){
                System.out.println("First name:");
                String firstName = scanner.nextLine();
                System.out.println("Last name:");
                String lastName =  scanner.nextLine();
                System.out.println("Phone number:");
                String phoneNumber = scanner.nextLine();
                System.out.println("Email: ");
                String email = scanner.nextLine();
                System.out.println("Job Title:");
                String jobTitle = scanner.nextLine();
                System.out.println("Salary:");
                int salary = Integer.parseInt(scanner.nextLine());
                service.addEmployee(new Employee(firstName, lastName, phoneNumber, email, jobTitle, salary));
            }

            if (option == 3){
                int localOption = -1;
                System.out.println("Choose item type:\n" +
                        "1.House\n" +
                        "2.Car\n" +
                        "3.Other item\n" +
                        "0.Cancel");
                localOption = Integer.parseInt(scanner.nextLine());
                if (localOption == 1) {
                    System.out.println("House name:");
                    String name = scanner.nextLine();
                    System.out.println("Estimated price:");
                    int estimatedPrice = Integer.parseInt(scanner.nextLine());
                    System.out.println("Choose owner id");
                    service.showAllUsers();
                    int ownerId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Surface: ");
                    int surface = Integer.parseInt(scanner.nextLine());
                    System.out.println("Address:");
                    String address = scanner.nextLine();
                    service.addItem(new House(name, estimatedPrice, service.getUserById(ownerId), surface, address));
                }

                if (localOption == 2) {
                    System.out.println("Car name:");
                    String name = scanner.nextLine();
                    System.out.println("Estimated price:");
                    int estimatedPrice = Integer.parseInt(scanner.nextLine());
                    System.out.println("Choose owner id");
                    service.showAllUsers();
                    int ownerId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Fuel: ");
                    String fuel = scanner.nextLine();
                    System.out.println("Mileage:");
                    int mileage = Integer.parseInt(scanner.nextLine());
                    System.out.println("Manufacturing year:");
                    int year = Integer.parseInt(scanner.nextLine());
                    service.addItem(new Car(name, estimatedPrice, service.getUserById(ownerId), fuel, mileage, year));
                }

                if (localOption == 3) {
                    System.out.println("Item name:");
                    String name = scanner.nextLine();
                    System.out.println("Estimated price:");
                    int estimatedPrice = Integer.parseInt(scanner.nextLine());
                    System.out.println("Choose owner id");
                    service.showAllUsers();
                    int ownerId = Integer.parseInt(scanner.nextLine());
                    service.addItem(new Item(name, estimatedPrice, service.getUserById(ownerId)));
                }
            }

            if (option == 4){
                System.out.println("Building name:");
                String name = scanner.nextLine();
                System.out.println("Building address:");
                String address = scanner.nextLine();
                System.out.println("Surface:");
                int surface = Integer.parseInt(scanner.nextLine());
                System.out.println("Maximum number of people:");
                int maxPeople = Integer.parseInt(scanner.nextLine());
                service.addBuilding(new Building(name, address, surface, maxPeople));
            }

            if (option == 5){
                int localOption = -1;
                List<Integer> auctionItemIds = new ArrayList<>();
                while (localOption != 0){
                    System.out.println("Add an item id or type 0 to continue:");
                    try{
                        service.showAllItems();
                        localOption = Integer.parseInt(scanner.nextLine());
                        if (localOption != 0) {
                            auctionItemIds.add(localOption);
                        }
                    }
                    catch (NoItemsException e){
                        System.out.println("There are no items to add!");
                        break;
                    }
                }
                System.out.println("Choose a building id:");
                service.showAllBuildings();
                int buildingId = Integer.parseInt(scanner.nextLine());

                System.out.println("Choose an employee id:");
                service.showAllEmployees();
                int employeeId = Integer.parseInt(scanner.nextLine());

                System.out.println("Choose auction date: (dd/mm/yyyy)");
                String dateString = scanner.nextLine();
                DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
                try {
                    Date date = formatter.parse(dateString);
                    service.addAuction(new Auction(auctionItemIds, service.getBuildingById(buildingId), service.getEmployeeById(employeeId), date, new ArrayList<>()));
                } catch (ParseException e) {
                    System.out.println("Invalid date!");
                    break;
                }

            }

            if (option == 6){
                System.out.println("Sum:");
                int sum = Integer.parseInt(scanner.nextLine());
                System.out.println("Choose bidder id:");
                service.showAllUsers();
                int bidderId = Integer.parseInt(scanner.nextLine());
                System.out.println("Choose auction id:");
                service.showAllAuctions();
                int auctionId = Integer.parseInt(scanner.nextLine());
                System.out.println("Choose item id:");
                service.showAllItemsAtAuction(auctionId);
                int itemId = Integer.parseInt(scanner.nextLine());
                try {
                    service.addBid(new Bid(sum, service.getUserById(bidderId), service.getAuctionById(auctionId), service.getItemById(itemId)));
                } catch (LowerBidException e) {
                    System.out.println("You must bid higher than the last bid for this item!");
                }
            }

            if (option == 7){
                try {
                    service.showAllItems();
                } catch (NoItemsException e) {
                    System.out.println("There are no items to show!");
                }
            }

            if(option == 8){
                service.showAllHouses();
            }

            if(option == 9){
                service.showAllCars();
            }

            if(option == 10){
                System.out.println("Choose item id:");
                try {
                    service.showAllItems();
                    int id = Integer.parseInt(scanner.nextLine());
                    service.setItemAsSoldById(id);
                } catch (NoItemsException e) {
                    System.out.println("There are no items!");
                }
            }
            if(option == 11){
                int dbOption = -1;
                System.out.println(
                        "Choose entity type:\n" +
                                "1.user\n" +
                                "2.item\n" +
                                "3.building\n" +
                                "4.auction\n"
                );
                dbOption = Integer.parseInt(scanner.nextLine());
                System.out.println(
                        "Choose action type:\n" +
                                "1.add\n" +
                                "2.list all\n" +
                                "3.update\n"+
                                "4.delete\n"
                );
                UserService userService = UserService.getInstance();
                ItemService itemService = ItemService.getInstance();
                AuctionService auctionService = AuctionService.getInstance();
                BuildingService buildingService = BuildingService.getInstance();
                LogService logService = LogService.getInstance();

                int dbActionOption = -1;
                dbActionOption = Integer.parseInt(scanner.nextLine());

                if(dbOption == 1){
                    if(dbActionOption == 1){
                        System.out.println("First name:\n");
                        String firstName = scanner.nextLine();
                        System.out.println("Last name:\n");
                        String lastName = scanner.nextLine();
                        System.out.println("Phone number:\n");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Email:\n");
                        String email = scanner.nextLine();
                        UserService.addUser(firstName, lastName, phoneNumber, email);
                        logService.logAction("create", "user");
                    }
                    if(dbActionOption == 2){
                        UserService.showAllUsers();
                        logService.logAction("read", "user");
                    }
                    if(dbActionOption == 3){
                        System.out.println("Phone number:\n");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Email: \n");
                        String email = scanner.nextLine();
                        UserService.updateUserPhoneByEmail(email, phoneNumber);
                        logService.logAction("update", "user");
                    }
                    if(dbActionOption == 4){
                        System.out.println("Email:\n");
                        String email = scanner.nextLine();
                        UserService.deleteUserByEmail(email);
                        logService.logAction("delete", "user");
                    }
                }
                if(dbOption == 2){
                    if(dbActionOption == 1){
                        System.out.println("Item name:\n");
                        String name = scanner.nextLine();
                        System.out.println("Price:\n");
                        int price = Integer.parseInt(scanner.nextLine());
                        System.out.println("Owner email: \n");
                        String email = scanner.nextLine();
                        ItemService.addItem(name, price, email);
                        logService.logAction("create", "item");
                    }
                    if(dbActionOption == 2){
                        ItemService.showAllItems();
                        logService.logAction("read", "item");
                    }
                    if(dbActionOption == 3){
                        System.out.println("Item id:\n");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.println("New price: \n");
                        int price = Integer.parseInt(scanner.nextLine());
                        ItemService.updateItemPriceById(id, price);
                        logService.logAction("update", "item");
                    }
                    if(dbActionOption == 4){
                        System.out.println("Item id:\n");
                        int id = Integer.parseInt(scanner.nextLine());
                        ItemService.deleteItemById(id);
                        logService.logAction("delete", "item");
                    }
                }
                if(dbOption == 3){
                    if(dbActionOption == 1){
                        System.out.println("Building name: \n");
                        String name = scanner.nextLine();
                        System.out.println("Address: \n");
                        String address = scanner.nextLine();
                        System.out.println("Surface: \n");
                        int surface = Integer.parseInt(scanner.nextLine());
                        System.out.println("Maximum number of people:\n");
                        int maxPeople = Integer.parseInt(scanner.nextLine());
                        BuildingService.addBuilding(name, address, surface, maxPeople);
                        logService.logAction("create", "building");
                    }
                    if(dbActionOption == 2){
                        BuildingService.showAllBuildings();
                        logService.logAction("read", "building");
                    }
                    if(dbActionOption == 3){
                        System.out.println("Building name:\n");
                        String name = scanner.nextLine();
                        System.out.println("New maximum number of people: \n");
                        int maxPeople = Integer.parseInt(scanner.nextLine());
                        BuildingService.updateMaxPeopleByName(name, maxPeople);
                        logService.logAction("update", "building");
                    }
                    if(dbActionOption == 4){
                        System.out.println("Buidling name: \n");
                        String name = scanner.nextLine();
                        BuildingService.deleteBuildingByName(name);
                        logService.logAction("delete", "building");
                    }
                }
                if (dbOption == 4){
                    if(dbActionOption == 1){
                        System.out.println("Employee email: \n");
                        String email = scanner.nextLine();
                        System.out.println("Building name: \n");
                        String buildingName = scanner.nextLine();
                        AuctionService.addAuction(email, buildingName);
                        logService.logAction("create", "auction");
                    }
                    if(dbActionOption == 2){
                        AuctionService.showAllAuctions();
                        logService.logAction("read", "auction");
                    }
                    if(dbActionOption == 3){
                        System.out.println("Auction id:\n");
                        int auctionId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Employee email:\n");
                        String employeeEmail = scanner.nextLine();
                        AuctionService.updateEmployeeById(employeeEmail, auctionId);
                        logService.logAction("update", "auction");
                    }
                    if(dbActionOption == 4){
                        System.out.println("Auction id:\n");
                        int auctionId = Integer.parseInt(scanner.nextLine());
                        AuctionService.deleteAuctionById(auctionId);
                        logService.logAction("delete", "auction");
                    }
                }
            }

        }






//        service.addItem(new Item("Tablou", 100, new User("Popescu", "Ion", "02345423", "email")));
//        service.addItem(new Item("Inel", 100, new User("Popescu", "Ion", "0234", "13243")));
////        service.showAllItems();
//        service.addItem(new House("apart", 10000,  new User("Popescu", "Ion", "0234", "13243"), 48, "str smsdfs"));
//        service.showAllHouses();
////        service.showAllItems();
//        service.addUser( new User("Popescu", "Ion", "0234", "13243"));
//        service.addUser( new User("Gigi", "Smenaru", "06435434", "3454232"));
//        System.out.println(service.getUserById(4));
//        System.out.println(service.getUserById(5));
//        System.out.println(service.getUserById(2));

//        service.addUser(new User("Ana", "Blandiana", "123456789", "email@email.com"));
//        service.addEmployee(new Employee("Mihai", "Popescu", "32874", "ymail@ymail.com", "vanzator", 2000));
//        service.addItem(new Item("inel", 1000, service.getUserById(1)));
//        service.addBuilding(new Building("Pentagon", "adresa", 1000, 100));
//        List<Item> items = new ArrayList<Item>();
//        items.add(service.getItemById(1));
//        List<Bid> bids = new ArrayList<Bid>();
//        service.addAuction(new Auction(items, service.getBuildingById(1), service.getEmployeeById(1), new Date(), bids));
//        try {
//            service.addBid(new Bid(100, service.getUserById(1), service.getAuctionById(1), service.getItemById(1)));
//            service.addBid(new Bid(110, service.getUserById(1), service.getAuctionById(1), service.getItemById(1)));
//            service.addBid(new Bid(10, service.getUserById(1), service.getAuctionById(1), service.getItemById(1)));
//            service.showAllItems();
//        }
//        catch (LowerBid e){
//            System.out.println(e.getExceptionMessage() + " Error code: " + e.getExceptionCode());
//        }
//        catch (NoItems e){
//            System.out.println(e.getExceptionMessage() + " Error code: " + e.getExceptionCode());
//
//
//        service.showAllBids();
    }
}