import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Usamos el generador para arrancar con un laberinto aleatorio de 15x15
        GeneradorLaberinto generadorInicial = new GeneradorLaberinto();
        int[][] laberintoAleatorio = generadorInicial.generar(15, 15);

        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal(laberintoAleatorio);
            ventana.setVisible(true);
        });
    }
}