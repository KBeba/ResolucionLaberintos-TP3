import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.List;

public class PanelLaberinto extends JPanel {
    private int[][] matriz;
    private List<Nodo> camino;
    private final int TAMAÑO_CELDA = 30; // Tamaño en píxeles de cada casilla

    public PanelLaberinto(int[][] matriz) {
        this.matriz = matriz;
        this.camino = null; // Al inicio no hay camino calculado
    }

    // Permite actualizar el camino desde la ventana principal y redibujar
    public void setCamino(List<Nodo> camino) {
        this.camino = camino;
        repaint(); // Vuelve a ejecutar paintComponent de forma automatica
    }

    // Permite cambiar la matriz base del laberinto por una nueva
    public void actualizarMatriz(int[][] nuevaMatriz) {
        this.matriz = nuevaMatriz;
        this.camino = null; // Al cambiar el laberinto borramos el camino viejo automáticamente
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (matriz == null) return;

        // 1. Dibujar el laberinto base (Paredes y Caminos vacíos)
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[0].length; col++) {
                if (matriz[fila][col] == 1) {
                    g.setColor(Color.BLACK); // Paredes
                } else {
                    g.setColor(Color.WHITE); // Pasillo libre
                }

                // Rellenar el cuadrado de la celda
                g.fillRect(col * TAMAÑO_CELDA, fila * TAMAÑO_CELDA, TAMAÑO_CELDA, TAMAÑO_CELDA);

                // Dibujar un borde gris suave para distinguir las cuadrículas
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(col * TAMAÑO_CELDA, fila * TAMAÑO_CELDA, TAMAÑO_CELDA, TAMAÑO_CELDA);
            }
        }

        // 2. Si existe un camino resuelto, destacarlo
        if (camino != null && !camino.isEmpty()) {
            g.setColor(new Color(46, 204, 113)); // Verde esmeralda para el camino

            for (Nodo nodo : camino) {
                // El modelo guarda (fila, columna), pero Graphics dibuja en (X=columna, Y=fila)
                int x = nodo.getY() * TAMAÑO_CELDA;
                int y = nodo.getX() * TAMAÑO_CELDA;

                // Margen interno pequeño para que el camino se vea estilizado dentro de la celda
                g.fillRect(x + 4, y + 4, TAMAÑO_CELDA - 8, TAMAÑO_CELDA - 8);
            }

            // Pintar el Inicio de Azul y el Fin de Rojo para identificarlos fácilmente
            pintarCeldaEspecial(g, camino.get(0), Color.BLUE);
            pintarCeldaEspecial(g, camino.get(camino.size() - 1), Color.RED);
        }
    }

    private void pintarCeldaEspecial(Graphics g, Nodo nodo, Color color) {
        g.setColor(color);
        int x = nodo.getY() * TAMAÑO_CELDA;
        int y = nodo.getX() * TAMAÑO_CELDA;
        g.fillRect(x + 2, y + 2, TAMAÑO_CELDA - 4, TAMAÑO_CELDA - 4);
    }
}