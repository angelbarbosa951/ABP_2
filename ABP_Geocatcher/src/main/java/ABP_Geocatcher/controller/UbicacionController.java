package ABP_Geocatcher.controller;

import ABP_Geocatcher.model.Ubicacion;
import ABP_Geocatcher.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UbicacionController {
    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping("/ubicacion")
    public ResponseEntity getUbicacion(){
        ArrayList<Ubicacion> ubicacionArrayList = new ArrayList<>();
        ubicacionArrayList.add(
                new Ubicacion(
                    1,"Barcelona","en centro",1
                )
        );
        if(ubicacionArrayList.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(ubicacionArrayList);

    }
}
