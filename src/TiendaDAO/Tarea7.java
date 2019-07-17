/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaDAO;

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
public class Tarea7 {
    public static ArrayList<Tarea7pais> listararticulopornombre(String nom){
    ArrayList <Tarea7pais> listarpaisfecha = new ArrayList<>();
    String sql="Select p.pais, e.fecha, e.total from pais p, cliente c, pedido_encabezado e where p.idpais=c.idpais and c.idcliente = e.idcliente and c.nombres = ?";
    Connection cn = Conexion.abrir();
    Tarea7pais tp;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,nom);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            tp=new Tarea7pais();
            tp.setPais(rs.getString(1));
            tp.setFecha(rs.getDate(2));
            tp.setMonto(rs.getDouble(3));
            
             listarpaisfecha.add(tp);
            }
            rs.close();
            ps.close(); 
            cn.close();
            
        } catch (SQLException ex) {
           return null;
        }
    return  listarpaisfecha ;
    }
}
