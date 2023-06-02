package database;

import item.Item;
import person.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public final class ItemService {
    private static ItemService instance;
    private static Connection con = MysqlConnection.getConnection();
    private ItemService(){};

    public static ItemService getInstance(){
        if(instance == null){
            instance = new ItemService();
        }
        return instance;
    }

    public static void showItemById(int id){
        String select = "select * from items where id = ?";
        try{
            PreparedStatement selectstmt = con.prepareStatement(select);
            selectstmt.setInt(1, id);
            ResultSet rs = selectstmt.executeQuery();
            rs.next();
            System.out.println(rs.getString("name") + " " + Integer.toString(rs.getInt("price")) + " " + rs.getString("email"));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void showAllItems(){
        String select = "select * from items";
        try{
            Statement selectstmt = con.createStatement();
            ResultSet rs = selectstmt.executeQuery(select);
            while (rs.next()){
                System.out.println(rs.getString("name") + " " + Integer.toString(rs.getInt("price"))+ " " +rs.getString("email"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static boolean addItem(String name, int price, String email) {
        String add = "insert into items (name, price, email) values(?, ?, ?)";
        try{
            PreparedStatement addstmt = con.prepareStatement(add);
            addstmt.setString(1, name);
            addstmt.setInt(2, price);
            addstmt.setString(3, email);
            addstmt.executeUpdate();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public static boolean deleteItemById(int id){
        String deleteById = "delete from items where id = ?";
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

    public static boolean updateItemPriceById(int id, int price){
        String updatePrice= "update items set price = ? where id = ?";
        try{
            PreparedStatement updatestmt = con.prepareStatement(updatePrice);
            updatestmt.setInt(1, price);
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
