package org.example;

public class Main {
    public static void main(String[] args) {
        FabricaCampanasDeGauss fcg = new FabricaCampanasDeGauss();

        fcg.main(args);


        /*
        La interfaz grafica no funciona correctamente, por lo que utilizar el main de arriba para comprobar que los hilos funcionan correctamente


        en caso de funcionar el main se sustituiria por
        SimulacionGaussFrame frame = new SimulacionGaussFrame();
        frame.main(args);
         */

    }
}