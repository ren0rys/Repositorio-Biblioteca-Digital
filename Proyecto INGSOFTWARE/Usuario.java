import java.util.Map;
/** La clase abstracta Usuario representa un usuario genérico*/
abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String correo;
    protected String contraseña;
/**
     * Constructor de la clase Usuario.
     * @param id es el ID del usuario
     * @param nombre es el nombre del usuario
     * @param correo es el correo electrónico del usuario
     * @param contraseña es la contraseña del usuario
     */
    public Usuario(int id, String nombre, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }
/**
     * Método abstracto para iniciar sesión.
     */
    public abstract void iniciarSesion();
    /**
     * Método abstracto para cerrar sesión.
     */
    public abstract void logout();
    /**
     * Verifica si la contraseña proporcionada coincide con la del usuario.
     * @param password es la contraseña a verificar
     * @return true si la contraseña coincide, false en caso contrario
     */

    public boolean verifyPassword(String password) {
        return this.contraseña.equals(password);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
    
    public String getContraseña() {
        return contraseña;
    }
}
/**
 * Clase UsuarioNormal se extiende de Usuario, representa a un usuario normal.
 */

class UsuarioNormal extends Usuario {
    private String interes;
    /**
     * Constructor de la clase UsuarioNormal.
     * @param id es el ID del usuario
     * @param nombre es el nombre del usuario
     * @param correo es el correo electrónico del usuario
     * @param contraseña es la contraseña del usuario
     * @param interes es el interés del usuario
     */

    public UsuarioNormal(int id, String nombre, String correo, String contraseña, String interes) {
        super(id, nombre, correo, contraseña);
        this.interes = interes;
    }

    @Override
    public void iniciarSesion() {
        System.out.println(nombre + " ha iniciado sesión.");
    }

    @Override
    public void logout() {
        System.out.println(nombre + " ha cerrado sesión.");
    }

    public String getInteres() {
        return interes;
    }
}
/**
     * Clase UsuarioVIP que extiende de Usuario, representa a un usuario VIP.
     */
class UsuarioVIP extends Usuario {
    /**
     * Constructor de la clase UsuarioVIP.
     * @param id es el ID del usuario
     * @param nombre es el nombre del usuario
     * @param correo es el correo electrónico del usuario
     * @param contraseña es la contraseña del usuario
     */
    public UsuarioVIP(int id, String nombre, String correo, String contraseña) {
        super(id, nombre, correo, contraseña);
    }

    @Override
    public void iniciarSesion() {
        System.out.println(nombre + " ha iniciado sesión como VIP.");
    }

    @Override
    public void logout() {
        System.out.println(nombre + " ha cerrado sesión.");
    }
}
/** Clase Administrador que extiende de Usuario, representa a un administrador.*/
class Administrador extends Usuario {
    /**
     * Constructor de la clase Administrador.
     * @param id represebta el ID del administrador
     * @param nombre es el nombre del administrador
     * @param correo es el correo electrónico del administrador
     * @param contraseña es la contraseña del administrador
     */
    public Administrador(int id, String nombre, String correo, String contraseña) {
        super(id, nombre, correo, contraseña);
    }

    @Override
    public void iniciarSesion() {
        System.out.println(nombre + " ha iniciado sesión.");
    }

    @Override
    public void logout() {
        System.out.println(nombre + " ha cerrado sesión.");
    }
/**
     * Agrega un recurso digital y notifica a los suscriptores de la categoría correspondiente.
     * @param recurso el recurso digital a agregar
     * @param subscriptions el mapa de suscripciones categorizadas
     */
    public void agregarRecursoDigital(RecursoDigital recurso, Map<String, Subscription> subscriptions) {
        System.out.println("Recurso " + recurso.getNombre() + " agregado por " + nombre);
        if (subscriptions.containsKey(recurso.getCategoria())) {
            subscriptions.get(recurso.getCategoria()).notifySubscribers("Nuevo recurso disponible: " + recurso.getNombre());
        }
    }
    /**
     * Lista todos los usuarios registrados en el sistema.
     * @param users el mapa de usuarios registrados
     */
    public void listarUsuarios(Map<String, Usuario> users) {
        System.out.println("Lista de usuarios:");
        for (Usuario user : users.values()) {
            System.out.println("Nombre: " + user.getNombre() + ", Correo: " + user.getCorreo());
        }
    }
/**
     * Muestra todas las suscripciones categorizadas y el número de suscriptores en cada categoría.
     * @param subscriptions el mapa de suscripciones categorizadas
     */
    public void verSuscripciones(Map<String, Subscription> subscriptions) {
        System.out.println("Suscripciones:");
        for (Map.Entry<String, Subscription> entry : subscriptions.entrySet()) {
            System.out.println("Categoría: " + entry.getKey() + ", Número de suscriptores: " + entry.getValue().getSubscribers().size());
        }
    }
}
