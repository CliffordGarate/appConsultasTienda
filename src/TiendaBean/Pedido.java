/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaBean;

import java.sql.Date;

/**
 *
 * @author Dell
 */
public class Pedido {
    private int Idpedido;
    private Date fecha;
    private float total;
    private int Idempleado;

    public int getIdpedido() {
        return Idpedido;
    }

    public void setIdpedido(int Idpedido) {
        this.Idpedido = Idpedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getIdempleado() {
        return Idempleado;
    }

    public void setIdempleado(int Idempleado) {
        this.Idempleado = Idempleado;
    }
  
}
