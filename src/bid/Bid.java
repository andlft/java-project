package bid;

import auction.Auction;
import item.Item;
import person.User;

public class Bid {
    private int sum;
    private User bidder;
    private Auction auction;
    private Item item;

    public Bid(int sum, User bidder, Auction auction, Item item) {
        this.sum = sum;
        this.bidder = bidder;
        this.auction = auction;
        this.item = item;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString(){
        return "Sum: " + this.sum + " Bidder: " + this.bidder;
    }
}
