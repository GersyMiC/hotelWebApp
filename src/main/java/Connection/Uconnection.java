/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Gersy
 */
public class Uconnection {
    
    private static java.sql.Connection con=null;
    
    public static java.sql.Connection getConnection()throws  Exception{
    
        try {
            javax.naming.Context initContext=new InitialContext();
            javax.naming.Context envContext=(javax.naming.Context)initContext.lookup("java:/comp/env");
            DataSource ds=(DataSource)envContext.lookup("jdbc/mysqlDB");
            return ds.getConnection();
        } catch (Exception e) {
            throw e;
        }
    
    }
    /**private static Connection con=null;
    
    public static Connection getConnection()throws  Exception{
    
        try {
            Context initContext=new InitialContext();
            Context envContext=(Context)initContext.lookup("java:/comp/env");
            DataSource ds=(DataSource)envContext.lookup("jdbc/mysqlDB");
            return ds.getConnection();
        } catch (Exception e) {
            throw e;
        }
    
    }*/
    
}
