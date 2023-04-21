package Auction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Bid.Bid;
import Building.Building;
import Item.Item;
import Person.Employee;

public class Auction {
    private static int index= 0;
    private List<Integer> auctionedItemsIds;
    private Building building;
    private Employee auctioneer;
    private Date auctionDate;

    public Auction(List<Integer> auctionedItemsIds, Building building, Employee auctioneer, Date auctionDate, List<Bid> bids) {
        this.auctionedItemsIds = auctionedItemsIds;
        this.building = building;
        this.auctioneer = auctioneer;
        this.auctionDate = auctionDate;
        this.index++;
    }
    public Auction(){};

    public static int getIndex() {
        return index;
    }

    public List<Integer> getAuctionedItems() {
        return auctionedItemsIds;
    }

    public void setAuctionedItems(List<Integer> auctionedItemsIds) {
        this.auctionedItemsIds = auctionedItemsIds;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Employee getAuctioneer() {
        return auctioneer;
    }

    public void setAuctioneer(Employee auctioneer) {
        this.auctioneer = auctioneer;
    }

    public Date getAuctionDate() {
        return auctionDate;
    }

    public void setAuctionDate(Date auctionDate) {
        this.auctionDate = auctionDate;
    }

}
