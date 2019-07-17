/*
 * SELECT a.nombre 
FROM pedido_encabezado c, pedido_detalle b, articulo a
WHERE c.idpedido=b.idpedido and b.idarticulo=a.idarticulo 
and c.fecha >= '2016-02-19'
    AND c.fecha <= '2016-02-31'
 */
package TiendaDAO;

import ConexionTienda.Conexion;

import TiendaBean.Articulo;
import TiendaBean.TareaFecha;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ultron
 */
public class FechaArticulo {
    public static ArrayList<TareaFecha> listafecha(Date x, Date y){
    ArrayList <TareaFecha> listafecha= new ArrayList<>();
    Connection cn = Conexion.abrir();
    TareaFecha tf;
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT a.nombre, c.fecha FROM pedido_encabezado c, pedido_detalle b, articulo a WHERE c.idpedido=b.idpedido and b.idarticulo=a.idarticulo and c.fecha >= ? AND c.fecha <= ?");
            ps.setDate(1,x);
            ps.setDate(2, y);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            tf=new TareaFecha();
            tf.setArticulo(rs.getString(1));
            tf.setFecha(rs.getDate(2));
            
            listafecha.add(tf);
            }
            rs.close();
            ps.close(); 
            cn.close();
            
        } catch (SQLException ex) {
           return null;
        }
    return listafecha;
    }
}
