package ABP_Geocatcher.dao;

import ABP_Geocatcher.model.Ubicacion;
import ABP_Geocatcher.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Integer> {
}

