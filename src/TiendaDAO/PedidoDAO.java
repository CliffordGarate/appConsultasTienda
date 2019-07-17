/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaDAO;

import ConexionTienda.Conexion;
import TiendaBean.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class PedidoDAO {
     //LISTAR LOS PEDIDOS QUE HAN ATENDIDO LOS EMPLEADOS, DONDE EL NOMBRE DEL EMPLEADO SE INGRESA EN UN CAMPO DE TEXTO.......
    public static ArrayList<Pedido> pedidosPorEmpleado(String nom) {
       ArrayList<Pedido> lista = new ArrayList<>();
       
       //SENTENCIA SQL..................
       String sql = "SELECT e.idempleado, pe.idpedido, pe.fecha, pe.total from empleado e, pedido_encabezado pe WHERE e.idempleado = pe.idempleado  AND e.nombre =?";
       
       //ABRIMOS LA CONEXION...
        Connection cn = Conexion.abrir();
        //variable pedido
        Pedido Pd;
        try{
        PreparedStatement Ps = cn.prepareStatement(sql);
        Ps.setString(1, nom);
        //ejecutamos el SQL a traves del Ps....
            ResultSet Rs = Ps.executeQuery();
        //Leer el ResultSet...
        while(Rs.next()){
            //objeto de tipo pedido para capturar los datos que llegan del result....
            Pd = new Pedido();
            //guardar datos en el objeto Pd....
            Pd.setIdempleado(Rs.getInt(1));
            Pd.setIdpedido(Rs.getInt(2));
            Pd.setFecha(Rs.getDate(3));
            Pd.setTotal(Rs.getFloat(4));
          
            //agregamos objetos  a la lista..
            lista.add(Pd);   
        }
        Rs.close();
        Ps.close();
        cn.close();
        
    }catch(Exception e){
        return null;
    }
    return lista;
}
    
}
