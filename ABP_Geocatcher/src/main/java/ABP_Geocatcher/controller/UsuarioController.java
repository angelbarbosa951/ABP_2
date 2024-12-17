package ABP_Geocatcher.controller;

import ABP_Geocatcher.model.Usuario;
import ABP_Geocatcher.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;


@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public ResponseEntity getUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1,
                        "sola",
                        "1234",
                        1,
                        1,
                        "Angel",
                        "angelsola@gmail.com",
                        null,
                        Date.valueOf("2024-12-12"),
                        "Hola, buenas tardes"
                )
        );

        if(usuarios.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/usuario")
    public ResponseEntity postPic(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity putPic(@RequestBody Usuario usuario, @PathVariable int id) {
        try {
            // Cridem al servei per actualitzar l'usuari
            Usuario usuario = usuarioService.actualizarUsuario(id, usuarioActualizado);
            return ResponseEntity.ok(usuario); // Retornem l'usuari actualitzat
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Retornem 404 si l'usuari no es troba
        }
    }


    @PostMapping("/login")
    public ResponseEntity<String> postLogin(@RequestBody Usuario usuario) {
        String validEmail = "test@example.com";
        String validPassword = "password123";

        if (usuario.getEmail().equals(validEmail) && usuario.getPass().equals(validPassword)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

}