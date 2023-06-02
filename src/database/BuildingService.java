package database;

import building.Building;
import person.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class BuildingService {
    private static BuildingService instance;
    private static Connection con = MysqlConnection.getConnection();
    private BuildingService(){}
    public static BuildingService getInstance(){
        if(instance == null){
            instance = new BuildingService();
        }
        return instance;
    }

    public static Building getBuildingByName (String name){
        String select = "select * from buildings where lower(name) = lower(?)";
        try {
            PreparedStatement selectstmt = con.prepareStatement(select);
            selectstmt.setString(1, name);
            ResultSet rs = selectstmt.executeQuery();
            rs.next();
            return new Building(rs.getString("name"), rs.getString("address"), rs.getInt("surface"), rs.getInt("maxPeople"));
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static void showAllBuildings(){
        String select = "select * from buildings";
        try {
            Statement selectstmt = con.createStatement();
            ResultSet rs = selectstmt.executeQuery(select);
            while (rs.next()) {
                System.out.println(rs.getString("name")+" "+rs.getString("address")+" "+rs.getInt("surface")+" "+ rs.getInt("maxPeople"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static boolean addBuilding(String name, String address, int surface, int maxPeople) {
        String add = "insert into buildings (name, address, surface, maxPeople) values(?, ?, ?, ?)";
        try{
            PreparedStatement addstmt = con.prepareStatement(add);
            addstmt.setString(1, name);
            addstmt.setString(2, address);
            addstmt.setInt(3, surface);
            addstmt.setInt(4, maxPeople);
            addstmt.executeUpdate();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public static boolean deleteBuildingByName(String name){
        String deleteByName = "delete from buildings where name = ?";
        try{
            PreparedStatement deletestmt = con.prepareStatement(deleteByName);
            deletestmt.setString(1, name);
            deletestmt.executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public static boolean updateMaxPeopleByName(String name, int maxPeople){
        String updateMaxPeople = "update buildings set maxPeople = ? where name = ?";
        try{
            PreparedStatement updatestmt = con.prepareStatement(updateMaxPeople);
            updatestmt.setInt(1, maxPeople);
            updatestmt.setString(2, name);
            updatestmt.executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}

