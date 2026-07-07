import java.util.ArrayList;
import java.util.List;

public class Nodo {
    // Coordenadas en la matriz/tablero
    private final int x;
    private final int y;

    // Nodos adyacentes a los que se puede caminar
    private final List<Nodo> vecinos;

    // Atributos de control para los algoritmos de busqueda (BFS/DFS)
    private boolean visitado;
    private Nodo padre; // Nos permitirá reconstruir el camino al revés

    public Nodo(int x, int y) {
        this.x = x;
        this.y = y;
        this.vecinos = new ArrayList<>();
        this.visitado = false;
        this.padre = null;
    }

    public void agregarVecino(Nodo vecino) {
        if (!vecinos.contains(vecino)) {
            vecinos.add(vecino);
        }
    }

    // Getters y Setters
    public int getX() { return x; }
    public int getY() { return y; }
    public List<Nodo> getVecinos() { return vecinos; }

    public boolean isVisitado() { return visitado; }
    public void setVisitado(boolean visitado) { this.visitado = visitado; }

    public Nodo getPadre() { return padre; }
    public void setPadre(Nodo padre) { this.padre = padre; }

    // Limpia el estado del nodo para poder resolver el laberinto varias veces
    public void reiniciar() {
        this.visitado = false;
        this.padre = null;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}