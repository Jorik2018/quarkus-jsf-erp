package com.titanic.ventapasajes.ejb;

import com.titanic.ventapasajes.modelo.Recorrido;
import java.util.HashMap;
import java.util.List;
import jakarta.ejb.Local;

public interface RecorridoFacadeLocal {

    void create(Recorrido recorrido);

    void edit(Recorrido recorrido);

    void remove(Recorrido recorrido);

    Recorrido find(Object id);

    List<Recorrido> findAll();

    List<Recorrido> findRange(int[] range);

    long count();

    public Recorrido obtenerRecorridoPorRuta(String ruta);

    public Recorrido adicionarRecorrido(Recorrido recorrido);

    public List<Recorrido> listarRecorridosFiltrados(HashMap filtros);

    public void removerRecorrido(Recorrido recorridoSeleccionado);
    
}
