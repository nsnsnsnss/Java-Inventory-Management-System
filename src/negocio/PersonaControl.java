/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import datos.PersonaDAO;
import entidades.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JcarlosAd7
 */
public class PersonaControl {
    private final PersonaDAO DATOS;
    private Persona obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;
    
    public PersonaControl(){
        this.DATOS=new PersonaDAO();
        this.obj=new Persona();
        this.registrosMostrados=0;
    }
    
    public DefaultTableModel listar(String texto,int totalPorPagina,int numPagina){
        List<Persona> lista=new ArrayList();
        lista.addAll(DATOS.listar(texto,totalPorPagina,numPagina));
        
        String[] titulos={"Id","Tipo Persona","Persona","Documento","# Documento","Dirección","Teléfono","Email","Estado"};
        this.modeloTabla=new DefaultTableModel(null,titulos);        
        
        String estado;
        String[] registro = new String[9];
        
        this.registrosMostrados=0;
        for (Persona item:lista){
            if (item.isActivo()){
                estado="Activo";
            } else{
                estado="Inactivo";
            }
            registro[0]=Integer.toString(item.getId());
            registro[1]=item.getTipoPersona();
            registro[2]=item.getNombre();
            registro[3]=item.getTipoDocumento();
            registro[4]=item.getNumDocumento();
            registro[5]=item.getDireccion();
            registro[6]=item.getTelefono();
            registro[7]=item.getEmail();
            registro[8]=estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;
        }
        return this.modeloTabla;
    }
    
    public DefaultTableModel listarTipo(String texto,int totalPorPagina,int numPagina,String tipoPersona){
        List<Persona> lista=new ArrayList();
        lista.addAll(DATOS.listarTipo(texto,totalPorPagina,numPagina,tipoPersona));
        
        String[] titulos={"Id","Tipo Persona","Persona","Documento","# Documento","Dirección","Teléfono","Email","Estado"};
        this.modeloTabla=new DefaultTableModel(null,titulos);        
        
        String estado;
        String[] registro = new String[9];
        
        this.registrosMostrados=0;
        for (Persona item:lista){
            if (item.isActivo()){
                estado="Activo";
            } else{
                estado="Inactivo";
            }
            registro[0]=Integer.toString(item.getId());
            registro[1]=item.getTipoPersona();
            registro[2]=item.getNombre();
            registro[3]=item.getTipoDocumento();
            registro[4]=item.getNumDocumento();
            registro[5]=item.getDireccion();
            registro[6]=item.getTelefono();
            registro[7]=item.getEmail();
            registro[8]=estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;
        }
        return this.modeloTabla;
    }
       
    public String insertar(String tipoPersona, String nombre, String tipoDocumento, String numDocumento, String direccion, String telefono, String email){
        if (DATOS.existe(nombre)){
            return "El registro ya existe.";
        }else{
            obj.setTipoPersona(tipoPersona);
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumDocumento(numDocumento);
            obj.setDireccion(direccion);
            obj.setTelefono(telefono);
            obj.setEmail(email);
            
            if (DATOS.insertar(obj)){
                return "OK";
            }else{
                return "Error en el registro.";
            }
        }
    }
    
    public String actualizar(int id,String tipoPersona, String nombre, String nombreAnt, String tipoDocumento, String numDocumento, String direccion, String telefono, String email){
        if (nombre.equals(nombreAnt)){
            obj.setId(id);
            obj.setTipoPersona(tipoPersona);
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumDocumento(numDocumento);
            obj.setDireccion(direccion);
            obj.setTelefono(telefono);
            obj.setEmail(email);
            
            if(DATOS.actualizar(obj)){
                return "OK";
            }else{
                return "Error en la actualización.";
            }
        }else{
            if (DATOS.existe(nombre)){
                return "El registro ya existe.";
            }else{
                obj.setId(id);
                obj.setTipoPersona(tipoPersona);
                obj.setNombre(nombre);
                obj.setTipoDocumento(tipoDocumento);
                obj.setNumDocumento(numDocumento);
                obj.setDireccion(direccion);
                obj.setTelefono(telefono);
                obj.setEmail(email);
            
                if (DATOS.actualizar(obj)){
                    return "OK";
                }else{
                    return "Error en la actualización.";
                }
            }
        }
    }
    
    public String desactivar(int id){
        if (DATOS.desactivar(id)){
            return "OK";
        }else{
            return "No se puede desactivar el registro";
        }
    }
    
    public String activar(int id){
        if (DATOS.activar(id)){
            return "OK";
        }else{
            return "No se puede activar el registro";
        }
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }
}
