package ar.edu.unlam.tallerweb1.infrastructure.Registro;


import ar.edu.unlam.tallerweb1.domain.Usuarios.Usuario;
import ar.edu.unlam.tallerweb1.infrastructure.Registro.ServicioDeRegistro;
import ar.edu.unlam.tallerweb1.infrastructure.Usuario.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service("servicioDeRegistro")
@Transactional
public class ServicioDeRegistroImpl implements ServicioDeRegistro {

    private RepositorioUsuario servicioRegistroDao;

    @Autowired
    public ServicioDeRegistroImpl(RepositorioUsuario servicioRegistroDao){
        this.servicioRegistroDao = servicioRegistroDao;
    }
    public ServicioDeRegistroImpl(){
    }
    @Override
    public Boolean validarEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern patron = Pattern.compile(regex);
        Matcher matcher = patron.matcher(email);
        return matcher.matches();
    }
    public Boolean validarClave(String clave) {
        Pattern patron = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8,}$");
        Matcher matcher = patron.matcher(clave);
        return matcher.matches();
    }

    @Override
    public Boolean registrarUsuario(String email, String clave) {
          Boolean sonValidos= false;

           if (validarClave(clave) && validarEmail(email)){
               sonValidos=true;
               Usuario usuario = new Usuario(email, clave);
               servicioRegistroDao.guardar(usuario);
           }
           return sonValidos;
        }

    @Override
    public Boolean buscar(String email){
        Boolean existe = true;
        if (servicioRegistroDao.buscar(email) == null){
            existe = false;
        }
        return existe;
    }
}
