package app.android.frisco.myeasyfield.activities.repository;

import com.orm.SugarRecord;

import java.util.List;

import app.android.frisco.myeasyfield.activities.entities.Usuario;

public class UsuarioRepository {
    public static List<Usuario> list(){
        List<Usuario> usuario= SugarRecord.listAll(Usuario.class);
        return usuario;
    }

    public static Usuario read(Long id){
        Usuario usuario = SugarRecord.findById(Usuario.class, id);
        return usuario;
    }

    public static void create(String name, String lastname, String username, String email, String password){
        Usuario user = new Usuario(name, lastname, username, email, password);
        SugarRecord.save(user);
    }

    public static void update(String name, String lastname, String username, String email, String password, Long id){
        Usuario usuario = SugarRecord.findById(Usuario.class, id);
        usuario.setName(name);
        usuario.setLastname(lastname);
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(password);
    }

    public static void delete(Long id){
        Usuario usuario = SugarRecord.findById(Usuario.class, id);
        SugarRecord.delete(usuario);
    }
}