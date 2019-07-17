/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaDAO;

import ConexionTienda.Conexion;
import TiendaBean.MontoCat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 *select sum(pd.subtotal), c.categoria from pedido_encabezado pe, pedido_detalle pd, articulo a, categoria c WHERE pe.idpedido = pd.idpedido AND pd.idarticulo = a.idarticulo AND
a.idcategoria= c.idcategoria and c.idcategoria = 1
 */
public class tarea10 {
      public static ArrayList<MontoCat> Montocategoria(int cate){
    ArrayList <MontoCat> monti = new ArrayList<>();
    String sql="Select sum(pd.subtotal), c.categoria from pedido_encabezado pe, pedido_detalle pd, articulo a, categoria c WHERE pe.idpedido = pd.idpedido AND pd.idarticulo = a.idarticulo AND\n" +
"a.idcategoria= c.idcategoria and c.idcategoria = ?";
         Connection cn = Conexion.abrir();
    MontoCat tp;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,cate);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            tp=new MontoCat();
            tp.setMonto(rs.getFloat(1));
            
            tp.setCategoria(rs.getString(2));
            
             monti.add(tp);
            }
            rs.close();
            ps.close(); 
            cn.close();
            
        } catch (SQLException ex) {
           return null;
        }
    return  monti ;
    }
    
}
