package clases;

public class Datos {
    public boolean validarUsuario(String usuario, String clave) {
        if(usuario.equalsIgnoreCase("guzmanx1") && clave.equals("12345#$"))
            return true;
        else
            return false;

    }
}
