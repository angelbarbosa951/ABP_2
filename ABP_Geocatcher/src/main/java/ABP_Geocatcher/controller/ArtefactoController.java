package ABP_Geocatcher.controller;

import ABP_Geocatcher.model.Artefacto;
import ABP_Geocatcher.model.Ubicacion;
import ABP_Geocatcher.model.Usuario;
import ABP_Geocatcher.service.ArtefactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ArtefactoController {

    @Autowired
    private ArtefactoService artefactoService;

    //Get de artefactes:
    @GetMapping("/artefacte")
    public ResponseEntity<List<Artefacto>> getArtefactos() {
        List<Artefacto> artefactos = artefactoService.getArtefactos();
        if(artefactos.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(artefactos);
    }

    //GetById:
    @GetMapping("/artefacte/{id}")
    @ResponseBody
    public ResponseEntity<Artefacto> getArtefactoById(@PathVariable int id) {
        Artefacto artefacto = artefactoService.getArtefactosbyId(id);
        if (artefacto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Responde con 404 si no se encuentra
        }
        return ResponseEntity.ok(artefacto); // Responde con 200 OK si se encuentra
    }

    //Post:
    @PostMapping("/artefacte/create")
    public ResponseEntity postArtefacto(@RequestBody Artefacto artefacto) {
        return ResponseEntity.ok(artefacto);
    }

    //Put:
    @PutMapping("/artefacte/{id}")
    public ResponseEntity<Artefacto> updateArtefacto(@PathVariable int id, @RequestBody Artefacto artefactoActualizado) {
        return artefactoService.putArtefacte(id, artefactoActualizado);
    }

}
