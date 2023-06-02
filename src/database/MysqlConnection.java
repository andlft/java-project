package database;

import java.sql.*;
public final class MysqlConnection {
    private static Connection con = null;

    static{
        try{
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proiect_java", "root", "admin"
            );
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static Connection getConnection(){
        return con;
    }
}
