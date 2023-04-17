package Auction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Bid.Bid;
import Building.Building;
import Item.Item;
import Person.Employee;

public class Auction {
    private List<Item> auctionedItems;
    private Building building;
    private Employee auctioneer;
    private Date auctionDate;
    private List<Bid> bids;

    public Auction(List<Item> auctionedItems, Building building, Employee auctioneer, Date auctionDate, List<Bid> bids) {
        this.auctionedItems = auctionedItems;
        this.building = building;
        this.auctioneer = auctioneer;
        this.auctionDate = auctionDate;
        this.bids = bids;
    }

    public List<Item> getAuctionedItems() {
        return auctionedItems;
    }

    public void setAuctionedItems(List<Item> auctionedItems) {
        this.auctionedItems = auctionedItems;
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

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }
}
