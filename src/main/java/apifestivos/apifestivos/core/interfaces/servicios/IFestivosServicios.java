package apifestivos.apifestivos.core.interfaces.servicios;

import java.util.List;


import apifestivos.apifestivos.core.dominio.Festivo;

public interface IFestivosServicios {
    List<Festivo> listarFestivos();
    List<Festivo> buscarFestivosPorNombre(String nombre);
    String verificarDiaFeriado(int año, int mes, int día);
    
}
