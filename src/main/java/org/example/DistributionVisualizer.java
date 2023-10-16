package org.example;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DistributionVisualizer extends JPanel {
    private ArrayList<Integer> ballPositions;
    private int containerY;

    public DistributionVisualizer() {
        ballPositions = new ArrayList<>();
        containerY = 300; // Ajusta la posición vertical de los contenedores
    }

    public void updateBallPosition(int position) {
        ballPositions.add(position);
        repaint();
    }

    public void updateStatistics() {
        // Calcula estadísticas y muestra en la GUI
        // Por ejemplo, media y desviación estándar
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int containerWidth = getWidth();
        int numContainers = 10;

        int containerSpacing = containerWidth / numContainers;

        for (int i = 0; i < numContainers; i++) {
            int containerX = i * containerSpacing;
            int containerHeight = 20;

            g.drawRect(containerX, containerY, containerSpacing, containerHeight);
        }

        int ballSize = 10;
        for (int position : ballPositions) {
            int x = position * containerSpacing;
            int y = containerY - ballSize;
            g.fillOval(x, y, ballSize, ballSize);
        }
    }
}

