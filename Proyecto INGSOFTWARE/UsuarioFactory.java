/** Interfaz UsuarioFactory que define el método para crear usuarios.*/
interface UsuarioFactory {
    /** Crea un nuevo usuario
    * @param id el ID del usuario
     * @param nombre el nombre del usuario
     * @param correo el correo electrónico del usuario
     * @param contraseña la contraseña del usuario
     * @param interes el interés del usuario (puede ser null para algunos tipos de usuario)
     * @return un objeto Usuario
     */    
    Usuario crearUsuario(int id, String nombre, String correo, String contraseña, String interes);
}
/** Clase UsuarioNormalFactory que implementa la interfaz UsuarioFactory para crear usuarios normales.*/
class UsuarioNormalFactory implements UsuarioFactory {
    /**
    * Crea un nuevo usuario normal.
     *
     * @param id el ID del usuario
     * @param nombre el nombre del usuario
     * @param correo el correo electrónico del usuario
     * @param contraseña la contraseña del usuario
     * @param interes el interés del usuario
     * @return un objeto UsuarioNormal
     */
    @Override
    public Usuario crearUsuario(int id, String nombre, String correo, String contraseña, String interes) {
        return new UsuarioNormal(id, nombre, correo, contraseña, interes);
    }
}
/** Clase UsuarioVIPFactory implementa la interfaz UsuarioFactory para crear usuarios VIP.*/
class UsuarioVIPFactory implements UsuarioFactory {
    /**
    * Crea un nuevo usuario VIP.
     *
     * @param id el ID del usuario
     * @param nombre el nombre del usuario
     * @param correo el correo electrónico del usuario
     * @param contraseña la contraseña del usuario
     * @param interes no se utiliza para usuarios VIP, puede ser null
     * @return un objeto UsuarioVIP
     */    
    @Override
    public Usuario crearUsuario(int id, String nombre, String correo, String contraseña, String interes) {
        return new UsuarioVIP(id, nombre, correo, contraseña);
    }
}
/** Clase AdministradorFactory implementa la interfaz UsuarioFactory para crear administradores.*/
class AdministradorFactory implements UsuarioFactory {
    @Override
    /**
     * Crea un nuevo administrador.
     *
     * @param id el ID del administrador
     * @param nombre el nombre del administrador
     * @param correo el correo electrónico del administrador
     * @param contraseña la contraseña del administrador
     * @param interes no se utiliza para administradores, puede ser null
     * @return un objeto Administrador
     */

    public Usuario crearUsuario(int id, String nombre, String correo, String contraseña, String interes) {
        return new Administrador(id, nombre, correo, contraseña);
    }
}
