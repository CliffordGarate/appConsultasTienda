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


public class ArticuloDao {
    
     
    public static ArrayList<Articulo> listarcategoria(String categoria){
    ArrayList <Articulo> listararticulo = new ArrayList<>();
    String sql="Select a.idarticulo, a.nombre from articulo a, categoria c where a.idcategoria = c.idcategoria and c.categoria like ? ";
    Connection cn = Conexion.abrir();
    Articulo art;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,categoria);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            art=new Articulo();
            art.setIdarticulo(rs.getInt(1));
            art.setNombre(rs.getString(2));
            
            listararticulo.add(art);
            }
            rs.close();
            ps.close(); 
            cn.close();
            
        } catch (SQLException ex) {
           return null;
        }
    return listararticulo;
    }
    
}
