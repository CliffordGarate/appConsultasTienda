/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionTienda;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alumno
 */
public class Conexion {

    private static String url = "jdbc:mysql://localhost/tienda";
 private static String con = "12345678";
 private static String usu = "root";

 
 public static Connection abrir(){
     try {
         Class.forName("com.mysql.jdbc.Driver");
         Connection cn = (Connection) DriverManager.getConnection(url,usu,con);
         return cn;
     } catch (Exception ex) {
         System.out.println("Error" +ex);
          return null;
     }

 }
    
}
