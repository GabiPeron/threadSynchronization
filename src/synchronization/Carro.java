package synchronization;

import java.util.Random;

public class Carro extends Thread {
	private Corrida corrida;
	private int distancia = 0;
	private String nome;
	private Random random;
	private boolean stopped = false;
	
	public Carro(String nome, Corrida corrida) {
		super();
		this.nome = nome;
		this.corrida = corrida;
		this.random = new Random();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getDistancia() {
		return this.distancia;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public boolean getStopped() {
		return this.stopped;
	}
	
	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}
	
	public void correr(int distancia) {
		this.distancia += distancia;
	}
	
	public synchronized void pitstop() throws InterruptedException {
		System.out.println(this.nome + " entrou no pitstop!");
		
		Thread.sleep(random.nextInt(50000 - 10000) + 10000);
		
		System.out.println(this.nome + " saiu do pitstop!");
		
		this.setStopped(true);
	}
	
	public void run() {
		System.out.println(this.nome + " inicial: " + this.distancia);
		
		while (this.distancia < this.corrida.getDistancia()) {
			this.correr(random.nextInt(20));
			
			System.out.println(this.nome + " atual: " + this.distancia);
			
			if ((this.getDistancia() >= (corrida.getDistancia() / 2)) && !this.stopped) {
				try {
					this.pitstop();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(this.nome + " Finalizou a corrida com: " + this.distancia + " metros de distância");
	}
}
