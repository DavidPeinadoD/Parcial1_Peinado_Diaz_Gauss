    package org.example;


    import java.util.Random;

    public class Bolas implements Runnable {
        private static final int NUM_PASOS = 10;
        private int numBolas;
        private LineaEnsamblaje lineaEnsamblaje;
        private Random generador;

        public Bolas(int numBolas, LineaEnsamblaje lineaEnsamblaje) {
            this.numBolas = numBolas;
            this.lineaEnsamblaje = lineaEnsamblaje;
            this.generador = new Random();
        }

        @Override
        public void run() {
            for (int i = 0; i < numBolas; i++) {
                // Simula una bola cayendo a través del tablero de Galton
                int posicion = 0;
                for (int j = 0; j < NUM_PASOS; j++) {
                    if (generador.nextBoolean()) {
                        posicion++;
                    }
                }

                // Coloca la posición en el búfer compartido
                lineaEnsamblaje.colocarComponente(posicion);

                // Agrega información de registro para depuración
                System.out.println("Bola " + i + ": Posición " + posicion);
            }
        }

    }
