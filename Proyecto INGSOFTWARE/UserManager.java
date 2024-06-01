import java.util.HashMap;
import java.util.Map;

class UserManager {
    private Map<String, Usuario> users = new HashMap<>();

    public void registerUser(String username, Usuario user) {
        users.put(username, user);
    }

    public Usuario loginUser(String username, String password) {
        Usuario user = users.get(username);
        if (user != null && user.verifyPassword(password)) {
            user.iniciarSesion();
            return user;
        }
        return null;
    }

    public Map<String, Usuario> getUsers() {
        return users;
    }
}
