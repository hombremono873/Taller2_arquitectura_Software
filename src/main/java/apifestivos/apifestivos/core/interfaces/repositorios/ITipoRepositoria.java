package apifestivos.apifestivos.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import apifestivos.apifestivos.core.dominio.Tipo;

public interface ITipoRepositoria extends JpaRepository<Tipo, Integer>{

}
