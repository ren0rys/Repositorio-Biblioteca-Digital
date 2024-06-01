interface UsuarioFactory {
    Usuario crearUsuario(int id, String nombre, String correo, String contraseña, String interes);
}

class UsuarioNormalFactory implements UsuarioFactory {
    @Override
    public Usuario crearUsuario(int id, String nombre, String correo, String contraseña, String interes) {
        return new UsuarioNormal(id, nombre, correo, contraseña, interes);
    }
}

class UsuarioVIPFactory implements UsuarioFactory {
    @Override
    public Usuario crearUsuario(int id, String nombre, String correo, String contraseña, String interes) {
        return new UsuarioVIP(id, nombre, correo, contraseña);
    }
}

class AdministradorFactory implements UsuarioFactory {
    @Override
    public Usuario crearUsuario(int id, String nombre, String correo, String contraseña, String interes) {
        return new Administrador(id, nombre, correo, contraseña);
    }
}
