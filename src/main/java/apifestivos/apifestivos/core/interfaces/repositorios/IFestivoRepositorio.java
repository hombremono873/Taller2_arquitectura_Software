package apifestivos.apifestivos.core.interfaces.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import apifestivos.apifestivos.core.dominio.Festivo;


public interface IFestivoRepositorio extends JpaRepository<Festivo, Integer> {
      List<Festivo> findByNombre(String nombre);
      //@Query("SELECT f.nombre FROM Festivo f WHERE f.mes = :mes AND f.dia = :dia")
      //String findNombreByMesAndDia(@Param("mes") int mes, @Param("dia") int dia);

      //@Query("SELECT f.tipo.id FROM Festivo f WHERE f.mes = :mes AND f.dia = :dia")
      //Integer findIdTipoByMesAndDia(@Param("mes") int mes, @Param("dia") int dia);
      
}
