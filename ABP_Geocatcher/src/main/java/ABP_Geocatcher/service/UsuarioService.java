package ABP_Geocatcher.service;

import ABP_Geocatcher.dao.UsuarioRepository;
import ABP_Geocatcher.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    // Simulant una base de dades en memòria amb una ArrayList
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    // Constructor per omplir la llista amb alguns usuaris d'exemple
    public UsuarioService() {
        // Afegint usuaris d'exemple
        usuarios.add(new Usuario(1, "johndoe", "password123", 1, 1, "John Doe", "johndoe@example.com", null, new java.util.Date(), "Biografía de John"));
        usuarios.add(new Usuario(2, "janedoe", "password123", 2, 1, "Jane Doe", "janedoe@example.com", null, new java.util.Date(), "Biografía de Jane"));
    }

    // Mètode per actualitzar un usuari a partir del seu id
    public Usuario actualizarUsuario(int id, Usuario usuarioActualizado) {
        // Busquem l'usuari a la llista
        Optional<Usuario> usuarioOpt = usuarios.stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst();

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            // Actualitzem els camps de l'usuari
            usuario.setUsername(usuarioActualizado.getUsername());
            usuario.setPass(usuarioActualizado.getPass());
            usuario.setRol(usuarioActualizado.getRol());
            usuario.setEstado(usuarioActualizado.getEstado());
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuario.setFoto_perfil(usuarioActualizado.getFoto_perfil());
            usuario.setFecha_registro(usuarioActualizado.getFecha_registro());
            usuario.setBiografia(usuarioActualizado.getBiografia());

            return usuario;
        } else {
            throw new RuntimeException("Usuari no trobat amb id: " + id);
        }
    }

    // Mètode per obtenir tots els usuaris (per exemple, per fer proves)
    public ArrayList<Usuario> obtenerTodosLosUsuarios() {
        return usuarios;
    }

}
