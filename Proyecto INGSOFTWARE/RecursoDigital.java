/**Está clase permite crear objetos de tipo RecursoDigital y contiene los métodos necesarios para 
asignar los valores correspondientes a los atributos de los objetos creados*/

class RecursoDigital {
/** @param id es un numero que funciona como identificador del recurso
@param nombre guarda el norme del recurso
@param tipo define el tipo del recurso
@param contenido guarda el contenido del recurso
@param categoria guarda la categoria del recurso*/
    private int id;
    private String nombre;
    private String tipo;
    private String contenido;
    private String categoria;
/**Método constructor que recibe las cadenas y las asigna a los atributos correspondientes*/
    public RecursoDigital(int id, String nombre, String tipo, String contenido, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.contenido = contenido;
        this.categoria = categoria;
    }
/**Método para obtener el nombre y las categorias de los objetos*/
    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }
}
