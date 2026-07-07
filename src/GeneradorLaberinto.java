import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class GeneradorLaberinto {

    // Genera un laberinto aleatorio con dimensiones dadas.
    public int[][] generar(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];

        // Empezar llenando todo el mapa con paredes
        for (int i = 0; i < filas; i++) {
            Arrays.fill(matriz[i], 1);
        }

        // Tallar el laberinto empezando en una posicion interna impar
        carve(matriz, 1, 1);

        // Asegurar que la entrada (0,0) y la salida (fin, fin) estén libres
        matriz[0][0] = 0;
        matriz[filas - 1][columnas - 1] = 0;

        // Abrir paso desde las esquinas hacia el laberinto tallado
        matriz[1][0] = 0;
        matriz[filas - 1][columnas - 2] = 0;

        return matriz;
    }

    private void carve(int[][] matriz, int f, int c) {
        matriz[f][c] = 0;

        // Direcciones de movimiento saltando de a 2 casillas (Fila, Columna)
        Integer[] dirs = {0, 1, 2, 3};
        List<Integer> listDirs = Arrays.asList(dirs);
        Collections.shuffle(listDirs); // Mezclar direcciones aleatoriamente

        for (int dir : listDirs) {
            int df = 0, dc = 0;
            if (dir == 0) df = -2;      // Arriba
            else if (dir == 1) df = 2;  // Abajo
            else if (dir == 2) dc = -2; // Izquierda
            else if (dir == 3) dc = 2;  // Derecha

            int nf = f + df;
            int nc = c + dc;

            // Verificar limites y que la casilla destino sea una pared aun no visitada
            if (nf > 0 && nf < matriz.length - 1 && nc > 0 && nc < matriz[0].length - 1) {
                if (matriz[nf][nc] == 1) {
                    // Derribar el muro intermedio entre las celdas
                    matriz[f + df / 2][c + dc / 2] = 0;
                    carve(matriz, nf, nc);
                }
            }
        }
    }
}