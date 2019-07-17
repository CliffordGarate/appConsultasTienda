/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaDAO;

import ConexionTienda.Conexion;
import TiendaBean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Tarea9 {
    public static ArrayList<Cliente> listarclientesnopedidos(){
    ArrayList <Cliente> listacli = new ArrayList<>();
    String sql="select nombres from cliente where idcliente not in (SELECT idcliente from pedido_encabezado)";
    Connection cn = Conexion.abrir();
    Cliente tp;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            tp=new Cliente();
            tp.setNombre(rs.getString(1));
            
            
             listacli.add(tp);
            }
            rs.close();
            ps.close(); 
            cn.close();
            
        } catch (SQLException ex) {
           return null;
        }
    return  listacli ;
    }
}
