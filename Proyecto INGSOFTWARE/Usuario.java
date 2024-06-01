import java.util.Map;

abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String correo;
    protected String contraseña;

    public Usuario(int id, String nombre, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public abstract void iniciarSesion();
    public abstract void logout();
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

class UsuarioNormal extends Usuario {
    private String interes;

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

class UsuarioVIP extends Usuario {
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

class Administrador extends Usuario {
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

    public void agregarRecursoDigital(RecursoDigital recurso, Map<String, Subscription> subscriptions) {
        System.out.println("Recurso " + recurso.getNombre() + " agregado por " + nombre);
        if (subscriptions.containsKey(recurso.getCategoria())) {
            subscriptions.get(recurso.getCategoria()).notifySubscribers("Nuevo recurso disponible: " + recurso.getNombre());
        }
    }

    public void listarUsuarios(Map<String, Usuario> users) {
        System.out.println("Lista de usuarios:");
        for (Usuario user : users.values()) {
            System.out.println("Nombre: " + user.getNombre() + ", Correo: " + user.getCorreo());
        }
    }

    public void verSuscripciones(Map<String, Subscription> subscriptions) {
        System.out.println("Suscripciones:");
        for (Map.Entry<String, Subscription> entry : subscriptions.entrySet()) {
            System.out.println("Categoría: " + entry.getKey() + ", Número de suscriptores: " + entry.getValue().getSubscribers().size());
        }
    }
}
