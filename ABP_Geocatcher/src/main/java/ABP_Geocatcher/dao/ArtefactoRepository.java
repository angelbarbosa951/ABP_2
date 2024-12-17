package ABP_Geocatcher.dao;

import ABP_Geocatcher.model.Artefacto;
import ABP_Geocatcher.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtefactoRepository  extends JpaRepository<Artefacto, Integer> {
}
