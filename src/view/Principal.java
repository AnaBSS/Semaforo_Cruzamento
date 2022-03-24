package view;

import java.util.concurrent.Semaphore;

import controller.Cruzamento;

public class Principal {
	public static void main(String[] args) {
		int carro = 5;
		Semaphore semaforo = new Semaphore (1);
		
		for (int i = 1 ; i < carro ; i++) {
	    new Cruzamento (i, semaforo).start();
		}
		}
	}

