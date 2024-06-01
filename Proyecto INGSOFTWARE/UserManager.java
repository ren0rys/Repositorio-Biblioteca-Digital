import java.util.HashMap;
import java.util.Map;
/**
 * La clase UserManager maneja el registro y el inicio de sesión de usuarios.
 * Utiliza un mapa para almacenar los usuarios registrados.
 */
class UserManager {
    private Map<String, Usuario> users = new HashMap<>();
    /** 
     * Registra un nuevo usuario en el sistema.
     * @param username el nombre de usuario del nuevo usuario
     * @param user el objeto Usuario que representa al nuevo usuario
     */
    public void registerUser(String username, Usuario user) {
        users.put(username, user);
    }
    /**
     * Inicia sesión de un usuario existente en el sistema.
     * @param username el nombre de usuario del usuario que intenta iniciar sesión
     * @param password la contraseña del usuario que intenta iniciar sesión
     * @return el objeto Usuario si las credenciales son correctas, null en caso contrario
     */
    public Usuario loginUser(String username, String password) {
        Usuario user = users.get(username);
        if (user != null && user.verifyPassword(password)) {
            user.iniciarSesion();
            return user;
        }
        return null;
    }
    /**
     * Obtiene el mapa de todos los usuarios registrados.
     *
     * @return el mapa de usuarios
     */
    public Map<String, Usuario> getUsers() {
        return users;
    }
}
