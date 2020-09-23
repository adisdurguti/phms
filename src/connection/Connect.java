/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Adis Durguti
 */
public class Connect {
    
    public Connection getConnect(){
        Connection connect = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection("jdbc:sqlserver://localhost:50864;databaseName=Pharmacy;user=sa;password=durguti-1");
        }catch(Exception e){
            e.printStackTrace();
        }
        return connect;
    }
}
