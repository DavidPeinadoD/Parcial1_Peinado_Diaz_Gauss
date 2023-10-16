package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FabricaCampanasDeGauss {
    public static void main(String[] args) {
        // Crea la línea de ensamblaje y las estaciones de trabajo
        LineaEnsamblaje lineaEnsamblaje = new LineaEnsamblaje(100);
        Bolas bolas = new Bolas(10, lineaEnsamblaje); // Crea una instancia de Bolas

        EstacionTrabajo[] estaciones = new EstacionTrabajo[4];

        // Crea un ThreadPool para ejecutar las estaciones de trabajo
        ExecutorService executor = Executors.newFixedThreadPool(estaciones.length);

        // Inicializa y asigna trabajos a las estaciones de trabajo
        for (int i = 0; i < estaciones.length; i++) {
            estaciones[i] = new EstacionTrabajo("Estacion " + i, bolas, lineaEnsamblaje, null);
            executor.execute(estaciones[i]);
        }

        // Detén las estaciones de trabajo después de un tiempo
        // Espera durante 5 segundos
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// Detén las estaciones de trabajo
        for (EstacionTrabajo estacion : estaciones) {
            estacion.detener();
        }


        // Detiene el ThreadPool y las estaciones de trabajo
        executor.shutdown();
        for (EstacionTrabajo estacion : estaciones) {
            estacion.detener(); // Debes implementar este método en la clase EstacionTrabajo
        }

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                // Si no se completaron todos los hilos en 1 minuto
                System.out.println("No se completaron todos los hilos en el tiempo especificado.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
