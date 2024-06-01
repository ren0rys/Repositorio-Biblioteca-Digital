
import java.util.ArrayList;
import java.util.List;
/**
 * La clase SearchEngine representa un motor de búsqueda simple para recursos digitales.
 * Permite buscar recursos por nombre y categoría.
 */

class SearchEngine {
    private List<RecursoDigital> recursos;
/**
     * Construye un SearchEngine con una lista de recursos digitales.
     *
     * @param recursos la lista de recursos digitales a ser buscados
     */

    public SearchEngine(List<RecursoDigital> recursos) {
        this.recursos = recursos;
    }
    /**
     * Busca recursos digitales que contengan la consulta especificada en su nombre.
     * @param query la cadena de consulta para buscar en los nombres de los recursos
     * @return una lista de recursos digitales que contienen la consulta en su nombre
     */

    public List<RecursoDigital> search(String query) {
        List<RecursoDigital> resultados = new ArrayList<>();
        for (RecursoDigital recurso : recursos) {
            if (recurso.getNombre().toLowerCase().contains(query.toLowerCase())) {
                resultados.add(recurso);
            }
        }
        return resultados;
    }
/**
     * Busca recursos digitales que pertenezcan a la categoría especificada.
     *
     * @param categoria la categoría para buscar en los recursos
     * @return una lista de recursos digitales que pertenecen a la categoría especificada
     */

    public List<RecursoDigital> searchByCategory(String categoria) {
        List<RecursoDigital> resultados = new ArrayList<>();
        for (RecursoDigital recurso : recursos) {
            if (recurso.getCategoria().equalsIgnoreCase(categoria)) {
                resultados.add(recurso);
            }
        }
        return resultados;
    }
}
