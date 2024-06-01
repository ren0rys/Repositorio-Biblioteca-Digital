class RecursoDigital {
    private int id;
    private String nombre;
    private String tipo;
    private String contenido;
    private String categoria;

    public RecursoDigital(int id, String nombre, String tipo, String contenido, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.contenido = contenido;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }
}
