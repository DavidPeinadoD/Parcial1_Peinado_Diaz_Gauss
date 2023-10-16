package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LineaEnsamblaje {
    private Lock lock;
    private Condition notEmpty;
    private Condition notFull;
    private int[] buffer;
    private int count;
    private int size;

    public LineaEnsamblaje(int bufferSize) {
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
        buffer = new int[bufferSize];
        count = 0;
        size = bufferSize;
    }

    public void colocarComponente(int componente) {
        lock.lock();
        try {
            while (count == size) {
                notFull.await(); // Espera si el búfer está lleno
            }
            // Lógica para colocar un componente en el búfer compartido
            buffer[count] = componente;
            count++;
            notEmpty.signal();
            if (count == size) {
                retirarComponente();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public int retirarComponente() {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await(); // Espera si el búfer está vacío
            }
            // Lógica para retirar un componente del búfer compartido
            int componente = buffer[count - 1];
            count--;
            notFull.signal();
            return componente;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        } finally {
            lock.unlock();
        }
    }
}
