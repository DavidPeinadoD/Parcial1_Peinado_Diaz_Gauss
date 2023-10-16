# Parcial1_Peinado_Diaz_Gauss

## DavidPeinadoD/Parcial1_Peinado_Diaz_Gauss

# Título: La Operación de Galton en la Fábrica de Campanas de Gauss
En el año 1850, en un universo paralelo donde la tecnología avanzó rápidamente, Sir Francis Galton creó un dispositivo que llamó la "máquina de la distribución normal". Esta máquina, basada en su tablero de Galton, demostró que al caer bolas a través de una serie de clavos en ángulo, la distribución final de las bolas en los contenedores inferiores formaba una curva de campana, también conocida como una distribución normal o Gaussiana.

Galton fundó una fábrica, "Campanas de Gauss", para producir estas máquinas en masa y demostrar este fenómeno matemático al mundo. En la fábrica, varias estaciones de trabajo simultáneas producen diferentes componentes de la máquina, y el ensamblaje final se lleva a cabo en una línea de producción separada.

Tú, un brillante ingeniero de software de la época, has sido contratado para simular el proceso de producción utilizando hilos de ejecución para modelar la concurrencia de la fabricación. Debes cumplir con los siguientes requisitos:

Cada estación de trabajo de la fábrica es un hilo de ejecución independiente. Estos hilos deben coordinarse entre sí para asegurar que los componentes de la máquina se produzcan en el orden correcto y en las cantidades correctas para el ensamblaje final.

Implementa un mecanismo de sincronización para garantizar que los componentes de la máquina se produzcan y ensamblen de manera ordenada. Esto puede implicar el uso de locks, semáforos, o variables de condición.

Implementa la producción y el ensamblaje de la máquina como un problema de productor-consumidor. Las estaciones de trabajo que producen componentes son los productores, y la línea de ensamblaje es el consumidor.

Usa un modelo de memoria compartida para permitir la comunicación entre los hilos. Los componentes producidos por las estaciones de trabajo deben colocarse en un búfer compartido del que la línea de ensamblaje pueda retirarlos.

Implementa la distribución de las tareas de producción entre las estaciones de trabajo utilizando un algoritmo de scheduling. Puede ser round-robin, prioridad, más corto primero, etc.

Usa técnicas de programación paralela y distribuida para acelerar el proceso de producción. Esto puede implicar la distribución de la carga de trabajo entre varios procesadores o nodos de un sistema distribuido.

Tu misión final es mostrar cómo a medida que el número de bolas (simuladas con hilos) cae a través del tablero, la distribución final se acerca cada vez más a una distribución normal. Este fenómeno debe ser mostrado visualmente en tiempo real a medida que las bolas llegan a los contenedores inferiores.

El objetivo es utilizar el poder de la programación paralela y distribuida para ilustrar este fenómeno en un entorno de producción concurrente, y en el proceso, aprender más acerca de cómo implementar y coordinar hilos de ejecución en un entorno de programación real.
