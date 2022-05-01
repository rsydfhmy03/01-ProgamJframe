/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.SQLException;
public class Config {
    private static final String DB_NAME = "mahasiswa";
    private  static final String USER = "root";
    private static final String PASSWORD = "";
    private  static final String URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
    
    public static Connection configDB() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(URL ,USER, PASSWORD );
        return connection;
    }
    public static boolean isConnected(){
        try {
            Config.configDB();
            System.out.println("Database Terkoneksi");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
            return false;
       }
        
    }
    public static void main(String[] args) {
        isConnected();
    }
}
