package ar.edu.unlam.tallerweb1.domain.usuarios;


import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class ServicioDeRegistroImpl implements ServicioDeRegistro {



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
           }
           return sonValidos;
        }

}
