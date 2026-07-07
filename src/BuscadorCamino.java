import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Collections;

public class BuscadorCamino {

    // Encuentra el camino más corto entre dos puntos utilizando BFS.

    public List<Nodo> buscarCamino(Grafo grafo, Nodo inicio, Nodo fin) {
        // 1. Limpieza de seguridad: resetear estados de búsquedas anteriores
        grafo.reiniciarGrafo();

        if (inicio == null || fin == null) {
            return new LinkedList<>();
        }

        // Cola estructurada FIFO para controlar el orden de exploracion por capas
        Queue<Nodo> cola = new LinkedList<>();

        // Inicializar el punto de partida
        inicio.setVisitado(true);
        cola.add(inicio);

        boolean encontrado = false;

        // 2. Bucle principal del algoritmo BFS
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll(); // Extrae el siguiente nodo a evaluar

            // Si llegamos a la meta, detenemos la exploración
            if (actual == fin) {
                encontrado = true;
                break;
            }

            // Evaluar los pasillos vecinos conectados directamente
            for (Nodo vecino : actual.getVecinos()) {
                if (!vecino.isVisitado()) {
                    vecino.setVisitado(true);
                    vecino.setPadre(actual); // Guardamos de dónde venimos para reconstruir la ruta
                    cola.add(vecino);
                }
            }
        }

        // 3. Reconstrucción del camino si se logró conectar los puntos
        if (encontrado) {
            return reconstruirCamino(fin);
        }

        return new LinkedList<>(); // Retorna lista vacía si el laberinto está bloqueado
    }

    //Camina hacia atrás usando las referencias de los 'padres' desde el nodo destino hasta el origen.
    private List<Nodo> reconstruirCamino(Nodo fin) {
        List<Nodo> camino = new LinkedList<>();
        Nodo actual = fin;

        while (actual != null) {
            camino.add(actual);
            actual = actual.getPadre(); // Se mueve al eslabón anterior
        }

        // Como fuimos del final al inicio, invertimos la lista para la GUI
        Collections.reverse(camino);
        return camino;
    }
}