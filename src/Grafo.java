import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private final List<Nodo> nodos;

    public Grafo() {
        this.nodos = new ArrayList<>();
    }

    public void agregarNodo(Nodo nodo) {
        if (!nodos.contains(nodo)) {
            nodos.add(nodo);
        }
    }

    //Conecta dos nodos de forma bidireccional
    public void conectarNodos(Nodo n1, Nodo n2) {
        if (n1 != null && n2 != null) {
            n1.agregarVecino(n2);
            n2.agregarVecino(n1);
        }
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    //Restablece el estado de todos los nodos del grafo (visitado = false, padre = null)
    public void reiniciarGrafo() {
        for (Nodo nodo : nodos) {
            nodo.reiniciar();
        }
    }
}