/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.RolDAO;
import entidades.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JcarlosAd7
 */
public class RolControl {
    private final RolDAO DATOS;
    private Rol obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;
    
    public RolControl(){
        this.DATOS=new RolDAO();
        this.obj=new Rol();
        this.registrosMostrados=0;
    }
    
    public DefaultTableModel listar(){
        List<Rol> lista=new ArrayList();
        lista.addAll(DATOS.listar());
        
        String[] titulos={"Id","Nombre","Descripción"};
        this.modeloTabla=new DefaultTableModel(null,titulos);        
        
        String[] registro = new String[3];
        
        this.registrosMostrados=0;
        for (Rol item:lista){            
            registro[0]=Integer.toString(item.getId());
            registro[1]=item.getNombre();
            registro[2]=item.getDescripcion();
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;
        }
        return this.modeloTabla;
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }
    
}
