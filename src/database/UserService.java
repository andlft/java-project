package database;

import person.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class UserService {
    private static UserService instance;
    private static Connection con = MysqlConnection.getConnection();
    private UserService(){}

    public static UserService getInstance(){
        if(instance == null){
            instance = new UserService();
        }
        return instance;
    }

    public static void getUserByEmail(String email){
        String select = "select * from users where email = ?";
        try{
            PreparedStatement selectstmt = con.prepareStatement(select);
            selectstmt.setString(1, email);
            ResultSet rs = selectstmt.executeQuery();
            rs.next();
            System.out.println(rs.getString("first_name")+" "+rs.getString("last_name") +" "+ rs.getString("phone_number")+" "+rs.getString("email"));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void showAllUsers(){
        String select = "select * from users";
        try {
            Statement selectstmt = con.createStatement();
            ResultSet rs = selectstmt.executeQuery(select);
            while (rs.next()) {
                System.out.println(rs.getString("first_name")+" "+rs.getString("last_name") +" "+ rs.getString("phone_number")+" "+rs.getString("email"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public static boolean addUser(String firstName, String lastName, String phoneNumber, String email) {
        String add = "insert into users (first_name, last_name, phone_number, email) values(?, ?, ?, ?)";
        try{
            PreparedStatement addstmt = con.prepareStatement(add);
            addstmt.setString(1, firstName);
            addstmt.setString(2, lastName);
            addstmt.setString(3, phoneNumber);
            addstmt.setString(4, email);
            addstmt.executeUpdate();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public static boolean deleteUserByEmail(String email){
        String deleteAfterEmail = "delete from users where email = ?";
        try{
            PreparedStatement deletestmt = con.prepareStatement(deleteAfterEmail);
            deletestmt.setString(1, email);
            deletestmt.executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public static boolean updateUserPhoneByEmail(String email, String phone){
        String updatePhoneNumber = "update users set phone_number = ? where email = ?";
        try{
            PreparedStatement updatestmt = con.prepareStatement(updatePhoneNumber);
            updatestmt.setString(1, phone);
            updatestmt.setString(2, email);
            updatestmt.executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
