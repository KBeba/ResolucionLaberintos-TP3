public class ConversorLaberinto {

    // Convierte una matriz binaria en un objeto Grafo.
    public Grafo mapearMatriz(int[][] matriz) {
        Grafo grafo = new Grafo();
        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Matriz auxiliar para almacenar las referencias a los nodos creados
        // Nos permite buscar rapidamente si existe un nodo en una coordenada especifica
        Nodo[][] mapaNodos = new Nodo[filas][columnas];

        // PASO 1: Identificar caminos libres y crear los objetos Nodo
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                if (matriz[f][c] == 0) { // Si es una casilla transitable
                    Nodo nuevoNodo = new Nodo(f, c);
                    mapaNodos[f][c] = nuevoNodo;
                    grafo.agregarNodo(nuevoNodo);
                }
            }
        }

        // PASO 2: Recorrer los nodos creados y conectarlos con sus vecinos válidos

        // Para evitar duplicar conexiones, solo verificamos hacia la DERECHA y ABAJO
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                Nodo nodoActual = mapaNodos[f][c];

                if (nodoActual != null) {
                    // Verificar vecino de la DERECHA (misma fila, columna siguiente)
                    if (c + 1 < columnas) {
                        Nodo vecinoDerecha = mapaNodos[f][c + 1];
                        if (vecinoDerecha != null) {
                            grafo.conectarNodos(nodoActual, vecinoDerecha);
                        }
                    }

                    // Verificar vecino de ABAJO (fila siguiente, misma columna)
                    if (f + 1 < filas) {
                        Nodo vecinoAbajo = mapaNodos[f + 1][c];
                        if (vecinoAbajo != null) {
                            grafo.conectarNodos(nodoActual, vecinoAbajo);
                        }
                    }
                }
            }
        }

        return grafo;
    }
}