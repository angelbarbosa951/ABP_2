package ABP_Geocatcher.service;

import ABP_Geocatcher.dao.UsuarioRepository;
import ABP_Geocatcher.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usersRepositori;

    public ResponseEntity postUsuario(Usuario user){
        usersRepositori.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
