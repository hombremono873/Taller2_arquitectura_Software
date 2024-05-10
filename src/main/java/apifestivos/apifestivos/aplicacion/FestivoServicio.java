package apifestivos.apifestivos.aplicacion;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import apifestivos.apifestivos.core.dominio.Festivo;
import apifestivos.apifestivos.core.interfaces.repositorios.IFestivoRepositorio;
import apifestivos.apifestivos.core.interfaces.servicios.IFestivosServicios;

@Service
public class FestivoServicio implements IFestivosServicios {
    private final IFestivoRepositorio festivoRepositorio; // Inyecta el repositorio

    private Festivo[] arrayFestivos;

    public FestivoServicio(IFestivoRepositorio festivoRepositorio) {
        this.festivoRepositorio = festivoRepositorio;
        List<Festivo> festivos = festivoRepositorio.findAll();
        this.arrayFestivos = festivos.toArray(new Festivo[festivos.size()]);
       
    }

    @Override
    public List<Festivo> listarFestivos() {
        return festivoRepositorio.findAll();
    }

    @Override
    public List<Festivo> buscarFestivosPorNombre(String nombre) {
        return festivoRepositorio.findByNombre(nombre);
    }

    @Override
    public String verificarDiaFeriado(int año, int mes, int dia) {

        for (int i = 0; i < arrayFestivos.length; i++) {
            if ((arrayFestivos[i].getDia() == dia) && (arrayFestivos[i].getMes() == mes)) {
                if (arrayFestivos[i].getTipo().getId() == 1) {
                    return " Es festivo: " +arrayFestivos[i].getNombre() + " " + Fechas.enteroFecha(año, mes, dia);
                } else {
                    if (arrayFestivos[i].getTipo().getId() == 2) {
                        Date fecha = Fechas.enteroFecha(año, mes, dia);
                        fecha = Fechas.getSiguienteLunes(fecha);
                        return "Es festivo: " + arrayFestivos[i].getNombre() + " " + fecha;
                    }
                }
            } else {// Dia =0 mes =0
                String fecha = Fechas.getFestivo(año, mes, dia);
                if (fecha != "") {
                    return " Es festivo: " + fecha;
                }
            }
        }

        return "No es festivo";

    }
    

}