package controller;

import java.util.concurrent.Semaphore;

public class Cruzamento extends Thread {
	public static String sentido;
	public int carro;
	public Semaphore semaforo;
	
	public Cruzamento (int carro, Semaphore semaforo) {
		this.carro = carro;
		this.semaforo = semaforo;
	}
	
	public void Direcao () {
		switch (carro) {
		  case 1: sentido = "direita";
		          break;
	   	  case 2: sentido = "esquerda";
                  break;
	   	  case 3: sentido = "cima";
                  break;
	   	  case 4: sentido = "baixo";
                  break;
		}
	}
	
	public void run () {
		try {
			semaforo.acquire();
			Direcao ();
			System.out.println("O carro "+carro+" atravessou o cruzamento no sentido para "+sentido);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	

}
