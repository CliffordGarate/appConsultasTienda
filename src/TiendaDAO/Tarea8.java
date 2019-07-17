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

/**
 *
import ConexionTienda.Conexion;
import TiendaBean.Tarea7pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Tarea8 {
    public static ArrayList<Articulo> listararticulosnopedidos(){
    ArrayList <Articulo> listararticulos = new ArrayList<>();
    String sql="Select nombre from articulo where idarticulo not in (SELECT idarticulo from pedido_detalle)";
    Connection cn = Conexion.abrir();
    Articulo tp;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            tp=new Articulo();
            tp.setNombre(rs.getString(1));
            
            
             listararticulos.add(tp);
            }
            rs.close();
            ps.close(); 
            cn.close();
            
        } catch (SQLException ex) {
           return null;
        }
    return  listararticulos ;
    }
}
