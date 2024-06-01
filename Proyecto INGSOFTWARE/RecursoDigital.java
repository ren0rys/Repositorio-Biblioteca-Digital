/** Clase RecursoDigital que representa un recurso digital en la biblioteca**/
class RecursoDigital {
    private int id;
    private String nombre;
    private String tipo;
    private String contenido;
    private String categoria;
/** Constructor de la clase RecursoDigital
    * @param id el ID del recurso digital
     * @param nombre el nombre del recurso digital
     * @param tipo el tipo del recurso digital
     * @param contenido el contenido del recurso digital
     * @param categoria la categoría del recurso digital
     */
    public RecursoDigital(int id, String nombre, String tipo, String contenido, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.contenido = contenido;
        this.categoria = categoria;
    }
/** Obtiene el nombre del recurso digital.
@return el nombre del recurso digital*/
    public String getNombre() {
        return nombre;
    }
/**Obtiene la categoría del recurso digital.
@return la categoria a la que define el recurso digital*/
    public String getCategoria() {
        return categoria;
    }
}
