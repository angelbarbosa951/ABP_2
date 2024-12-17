package ABP_Geocatcher.service;

import ABP_Geocatcher.dao.ArtefactoRepository;
import ABP_Geocatcher.model.Artefacto;
import ABP_Geocatcher.model.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtefactoService {

    private final List<Artefacto> artefactos = new ArrayList<>();

    @Autowired
    private ArtefactoRepository artefactoRepository;

    public ArtefactoService() {
        // Crear ubicación de ejemplo
        Ubicacion ubicacion = new Ubicacion(1, "Barcelona", "En centro", 1);

        // Crear lista de artefactos simulados
        artefactos.add(new Artefacto(1, "Juguetes", "Juguetes de niños", ubicacion, 1));
        artefactos.add(new Artefacto(2, "Libro antiguo", "Libro del siglo XVIII", ubicacion, 1));
    }


    public List<Artefacto> getArtefactos() {
        return artefactos;
    }

    public Artefacto getArtefactosbyId(int id) {
        // Crear lista de artefactos
        for(Artefacto artefacto: artefactos){
            if(artefacto.getId() == id){
                return artefacto;
            }
        }

        return null;
    }

    public ResponseEntity postArtefacte(Artefacto artefacto){
        artefactoRepository.save(artefacto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    public ResponseEntity<Artefacto> putArtefacte(int id, Artefacto artefactoActualizado) {
        for (Artefacto artefacto : artefactos) {
            if (artefacto.getId() == id) {
                // Actualiza los campos del artefacto encontrado
                artefacto.setNombre(artefactoActualizado.getNombre());
                artefacto.setDescripcion(artefactoActualizado.getDescripcion());
                artefacto.setEstado(artefactoActualizado.getEstado());
                artefacto.setId_ubicacion(artefactoActualizado.getId_ubicacion());

                // Devuelve el artefacto actualizado con un status OK
                return ResponseEntity.ok(artefacto);
            }
        }

        // Si no se encuentra el artefacto, devuelve un 404 NOT FOUND
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
