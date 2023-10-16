package org.example;



import java.util.Random;

public class EstacionTrabajo implements Runnable {
    private String nombre;
    private Bolas bolas;
    private LineaEnsamblaje lineaEnsamblaje;
    private Random generador;

    private volatile  boolean detener = false;

    public EstacionTrabajo(String nombre, Bolas bolas, LineaEnsamblaje lineaEnsamblaje) {
        this.nombre = nombre;
        this.bolas = bolas;
        this.lineaEnsamblaje = lineaEnsamblaje;
        this.detener = false;
        this.generador = new Random();
    }

    @Override
    public void run() {
        while (!detener) {
            // Produce componentes
            int componente = producirComponente();

            // Agrega información de registro para depuración
            System.out.println(nombre + ": Componente producida - Posición: " + componente);

            // Coloca el componente en un búfer compartido
            lineaEnsamblaje.colocarComponente(componente);
        }
    }


    public void detener() {
        detener = true;
    }

    private int producirComponente() {
        // Lógica para producir componentes (puede ser más compleja)
        return generador.nextInt(100); // Genera un componente aleatorio (ajusta según sea necesario)
    }
}
