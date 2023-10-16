package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulacionGaussFrame extends JFrame implements Observer {
    private JPanel tableroPanel;
    private ExecutorService executor;
    private boolean simulacionEnCurso;
    private LineaEnsamblaje lineaEnsamblaje;

    public SimulacionGaussFrame(LineaEnsamblaje lineaEnsamblaje) {
        this.lineaEnsamblaje = lineaEnsamblaje;
        // Configurar el diseño de la interfaz
        setTitle("Simulación de Distribución Gaussiana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configura un tamaño cuadrado (ajusta según tus preferencias)
        int ventanaSize = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
        setSize(ventanaSize, ventanaSize);

        tableroPanel = new TableroPanel();
        add(tableroPanel, BorderLayout.CENTER);

        JButton startButton = new JButton("Iniciar Simulación");
        startButton.addActionListener(e -> iniciarSimulacion());

        JButton stopButton = new JButton("Detener Simulación");
        stopButton.addActionListener(e -> detenerSimulacion());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        add(buttonPanel, BorderLayout.SOUTH);

        executor = Executors.newFixedThreadPool(1);
        simulacionEnCurso = false;
    }

    private void iniciarSimulacion() {
        if (!simulacionEnCurso) {
            Bolas bolas = new Bolas(10000, lineaEnsamblaje);

            executor.execute(bolas);

            simulacionEnCurso = true;
        }
    }

    private void detenerSimulacion() {
        if (simulacionEnCurso) {
            executor.shutdownNow();
            simulacionEnCurso = false;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        // Actualizar la representación gráfica del tablero aquí
        tableroPanel.repaint();
    }

    public static void main(String[] args) {
        LineaEnsamblaje lineaEnsamblaje = new LineaEnsamblaje(100);
        SwingUtilities.invokeLater(() -> {
            SimulacionGaussFrame frame = new SimulacionGaussFrame(lineaEnsamblaje);
            frame.setVisible(true);
        });
    }

    class TableroPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibuja las bolas en el tablero
            int[] buffer = lineaEnsamblaje.getBuffer();
            for (int i = 0; i < buffer.length; i++) {
                int x = i * 20;  // Ajusta el espaciado
                int y = buffer[i] * 20; // Ajusta la posición vertical
                g.setColor(Color.BLUE);
                g.fillOval(x, y, 10, 10); // Dibuja una bola en la posición (x, y) basada en el buffer
            }
        }
    }
}
