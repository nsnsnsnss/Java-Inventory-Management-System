/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import java.util.List;

/**
 *
 * @author JcarlosAd7
 */
public interface CrudIngresoInterface<T,D> {
   public List<T> listar(String texto,int totalPorPagina,int numPagina);
   public List<D> listarDetalle(int id);
   public boolean insertar(T obj);
   public boolean anular(int id);
   public int total();
   public boolean existe(String texto1,String texto2);
}
