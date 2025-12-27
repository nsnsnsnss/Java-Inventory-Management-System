/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import database.Conexion;
import entidades.Rol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JcarlosAd7
 */
public class RolDAO {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public RolDAO(){
        CON=Conexion.getInstancia();
    }
    
    public List<Rol> listar() {
        List<Rol> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT * FROM rol");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Rol(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }
    
    public List<Rol> seleccionar() {
        List<Rol> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT id, nombre FROM rol ORDER BY nombre asc");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Rol(rs.getInt(1),rs.getString(2)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }
    
    public int total() {
        int totalRegistros=0;
        try {
            ps=CON.conectar().prepareStatement("SELECT COUNT(id) FROM rol");            
            rs=ps.executeQuery();
            
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id)");
            }            
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return totalRegistros;
    }

}
