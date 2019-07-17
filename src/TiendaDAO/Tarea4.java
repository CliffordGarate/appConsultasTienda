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
 * @author Dell
 */
public class Tarea4 {
     public static ArrayList<Articulo> listararti(String nom){
    ArrayList <Articulo> listararti = new ArrayList<>();
    String sql="Select c.nombres, a.idarticulo, a.nombre, a.descripcion, a.precio from articulo a, cliente c, pedido_encabezado pe, pedido_detalle pd where c.idcliente = pe.idcliente and pe.idpedido = pd.idpedido and pd.idarticulo = a.idarticulo and c.nombres = ? ";
    Connection cn = Conexion.abrir();
    Articulo art;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,nom);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            art=new Articulo();
            art.setCliente(rs.getString(1));
            art.setIdarticulo(rs.getInt(2));
            art.setNombre(rs.getString(3));
            art.setDescripcion(rs.getString(4));
            art.setPrecio(rs.getDouble(5));
            
            listararti.add(art);
            }
            rs.close();
            ps.close(); 
            cn.close();
            
        } catch (SQLException ex) {
           return null;
        }
    return listararti;
    }
}
