package ar.edu.unlam.tallerweb1.domain.Registro;



public interface ServicioDeRegistro {


    public Boolean validarEmail(String mail);
    public Boolean registrarUsuario(String mail, String clave);
    public Boolean buscar(String email);

}
