import java.util.ArrayList;
import java.util.List;

class SearchEngine {
    private List<RecursoDigital> recursos;

    public SearchEngine(List<RecursoDigital> recursos) {
        this.recursos = recursos;
    }

    public List<RecursoDigital> search(String query) {
        List<RecursoDigital> resultados = new ArrayList<>();
        for (RecursoDigital recurso : recursos) {
            if (recurso.getNombre().toLowerCase().contains(query.toLowerCase())) {
                resultados.add(recurso);
            }
        }
        return resultados;
    }

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
