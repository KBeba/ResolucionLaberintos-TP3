import javax.swing.*;
import java.awt.BorderLayout;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    private PanelLaberinto panelLaberinto;
    private int[][] matriz;

    // Inyección de dependencias de nuestras clases lógicas
    private ConversorLaberinto conversor;
    private BuscadorCamino buscador;
    private GeneradorLaberinto generador;

    public VentanaPrincipal(int[][] matriz) {
        this.matriz = matriz;
        this.conversor = new ConversorLaberinto();
        this.buscador = new BuscadorCamino();
        this.generador = new GeneradorLaberinto();

        setTitle("Resolución Automática de Laberintos con Grafos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicializar e incorporar nuestro panel de dibujo
        panelLaberinto = new PanelLaberinto(matriz);
        add(panelLaberinto, BorderLayout.CENTER);

        // Crear barra de herramientas con botones de control
        JPanel panelBotones = new JPanel();
        JButton btnResolver = new JButton("Resolver Laberinto");
        JButton btnReiniciar = new JButton("Nuevo Laberinto");

        // Acción Interactiva: Resolver
        btnResolver.addActionListener(e -> resolver());

        // Acción Interactiva: Generar uno nuevo aleatorio al clickear reiniciar
        btnReiniciar.addActionListener(e -> {
            int[][] nuevaMatriz = generador.generar(15, 15); // Tamaño 15x15 recomendado (debe ser impar)
            this.matriz = nuevaMatriz;
            panelLaberinto.actualizarMatriz(nuevaMatriz);
        });

        panelBotones.add(btnResolver);
        panelBotones.add(btnReiniciar);
        add(panelBotones, BorderLayout.SOUTH);

        // Ajustar tamaño automáticamente según la cuadrícula y centrar
        pack();
        setSize(matriz[0].length * 30 + 20, matriz.length * 30 + 90);
        setLocationRelativeTo(null);
    }

    private void resolver() {
        // 1. Transformar la matriz a un modelo de Grafo puro
        Grafo grafo = conversor.mapearMatriz(matriz);

        // 2. Buscar dinámicamente los nodos correspondientes al Inicio (0,0) y Fin (esquina inferior)
        Nodo nodoInicio = null;
        Nodo nodoFin = null;

        int ultimaFila = matriz.length - 1;
        int ultimaCol = matriz[0].length - 1;

        for (Nodo n : grafo.getNodos()) {
            if (n.getX() == 0 && n.getY() == 0) nodoInicio = n;
            if (n.getX() == ultimaFila && n.getY() == ultimaCol) nodoFin = n;
        }

        if (nodoInicio == null || nodoFin == null) {
            JOptionPane.showMessageDialog(this, "Las casillas de inicio o fin están bloqueadas por paredes.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Ejecutar el algoritmo de búsqueda (BFS) sobre las estructuras puras
        List<Nodo> caminoEncontrado = buscador.buscarCamino(grafo, nodoInicio, nodoFin);

        // 4. Pasar el resultado a la vista para que actualice su estado visual
        if (!caminoEncontrado.isEmpty()) {
            panelLaberinto.setCamino(caminoEncontrado);
        } else {
            JOptionPane.showMessageDialog(this, "Este laberinto no tiene una ruta de escape válida.", "Sin Solución", JOptionPane.WARNING_MESSAGE);
        }
    }
}