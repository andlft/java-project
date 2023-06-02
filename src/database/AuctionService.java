package database;

import auction.Auction;
import person.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class AuctionService {
    private static AuctionService instance;
    private static Connection con = MysqlConnection.getConnection();
    private AuctionService(){}

    public static AuctionService getInstance(){
        if (instance == null){
            instance = new AuctionService();
        }
        return instance;
    }

    public static void getAuctionById(int id){
        String select = "select * from auctions where id = ?";
        try{
            PreparedStatement selectstmt = con.prepareStatement(select);
            selectstmt.setInt(1, id);
            ResultSet rs = selectstmt.executeQuery();
            rs.next();
            System.out.println(rs.getInt("id")+" "+rs.getString("employee")+" "+rs.getString("building"));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void showAllAuctions(){
        String select = "select * from auctions";
        try {
            Statement selectstmt = con.createStatement();
            ResultSet rs = selectstmt.executeQuery(select);
            while (rs.next()) {
                System.out.println(rs.getInt("id")+" "+rs.getString("employee")+" "+rs.getString("building"));

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static boolean addAuction(String employee, String building) {
        String add = "insert into auctions (employee, building) values (?, ?)";
        try{
            PreparedStatement addstmt = con.prepareStatement(add);
            addstmt.setString(1, employee);
            addstmt.setString(2, building);
            addstmt.executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public static boolean deleteAuctionById(int id){
        String deleteById = "delete from auctions where id = ?";
        try{
            PreparedStatement deletestmt = con.prepareStatement(deleteById);
            deletestmt.setInt(1, id);
            deletestmt.executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public static boolean updateEmployeeById(String employee, int id){
        String updateEmployee = "update auctions set employee = ? where id = ?";
        try{
            PreparedStatement updatestmt = con.prepareStatement(updateEmployee);
            updatestmt.setString(1, employee);
            updatestmt.setInt(2, id);
            updatestmt.executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
