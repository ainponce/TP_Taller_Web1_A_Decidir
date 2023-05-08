package ar.edu.unlam.tallerweb1.domain.usuarios;



public interface ServicioDeRegistro {


    public Boolean validarEmail(String mail);
    public Boolean registrarUsuario(String mail, String clave);
}
