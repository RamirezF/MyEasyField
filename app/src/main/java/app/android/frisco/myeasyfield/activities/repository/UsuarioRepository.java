package app.android.frisco.myeasyfield.activities.repository;

import android.util.Log;
import android.widget.Toast;
import com.orm.SugarRecord;

import java.util.List;

import app.android.frisco.myeasyfield.activities.entities.Usuario;

public class UsuarioRepository {
    public static List<Usuario> list(){
        List<Usuario> usuario= SugarRecord.listAll(Usuario.class);
        return usuario;
    }

    public static Usuario find(String user, String pass){
        List<Usuario> u= SugarRecord.find(Usuario.class, "USERNAME= '"+user+"' AND PASSWORD= '"+pass+"' ");
        if (u.size()==0){
            return null;
        }else{
            Usuario us = u.get(0);
            return us;
        }
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