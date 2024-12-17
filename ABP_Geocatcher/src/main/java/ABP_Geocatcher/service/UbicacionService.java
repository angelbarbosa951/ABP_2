package ABP_Geocatcher.service;

import ABP_Geocatcher.dao.UbicacionRepository;
import ABP_Geocatcher.model.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UbicacionService {
    @Autowired
    private UbicacionRepository ubicacionRepository;

    public ResponseEntity postUbicacion(Ubicacion ubicacion){
        ubicacionRepository.save(ubicacion);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
