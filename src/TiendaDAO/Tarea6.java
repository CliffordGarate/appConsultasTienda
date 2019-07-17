/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaDAO;

import ConexionTienda.Conexion;
import TiendaBean.Articulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Tarea6 {
     public static ArrayList<Articulo> listararticulopornombre(String nom){
    ArrayList <Articulo> listararticulopornombre = new ArrayList<>();
    String sql="Select nombre from articulo  where nombre LIKE ? ";
    Connection cn = Conexion.abrir();
    Articulo art;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,nom+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            art=new Articulo();
            art.setNombre(rs.getString(1));
            
             listararticulopornombre.add(art);
            }
            rs.close();
            ps.close(); 
            cn.close();
            
        } catch (SQLException ex) {
           return null;
        }
    return  listararticulopornombre ;
    }
}
