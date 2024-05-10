package apifestivos.apifestivos.presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import apifestivos.apifestivos.core.dominio.Festivo;
import apifestivos.apifestivos.core.interfaces.repositorios.IFestivoRepositorio; // Importa el repositorio
import apifestivos.apifestivos.core.interfaces.servicios.IFestivosServicios;

@RestController
@RequestMapping("/api/festivos") // Ruta del controlador
public class FestivoControlador {
    private final IFestivoRepositorio festivoRepositorio; // Inyecta el repositorio
    private final IFestivosServicios servicios;
    public FestivoControlador(IFestivoRepositorio festivoRepositorio, IFestivosServicios servicios) {
        this.festivoRepositorio = festivoRepositorio;
        this.servicios = servicios;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET) // Ruta para listar todos los festivos
    public List<Festivo> listarFestivos() {
        return festivoRepositorio.findAll();
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.GET) // Ruta para buscar festivos por nombre
    public List<Festivo> buscarFestivosPorNombre(@RequestParam String nombre) {
        return festivoRepositorio.findByNombre(nombre);
    }

    @GetMapping("/verificar")
    public String verificarFechaFestiva1(@RequestParam int anio, @RequestParam int mes, @RequestParam int dia) {
        return servicios.verificarDiaFeriado(anio, mes, dia);
    }
    
    @GetMapping("/verificar/{anio}/{mes}/{dia}") 
    public String verificarFechaFestiva(@PathVariable int anio, @PathVariable int mes, @PathVariable int dia) { 
        servicios.listarFestivos(); // Invocamos el método listarFestivos() antes de verificar la fecha festiva
        return servicios.verificarDiaFeriado(anio, mes, dia);
    }
}