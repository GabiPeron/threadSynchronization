package synchronization;

public class Corrida {
	private int distancia = 0;
	
	public Corrida(int distancia) {
		this.distancia = distancia;
	}
	
	public int getDistancia() {
		return this.distancia;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public Carro iniciar() {
		Carro competidor1 = new Carro("Número 1", this);
		Carro competidor2 = new Carro("Número 2", this);
		Carro competidor3 = new Carro("Número 3", this);
		Carro competidor4 = new Carro("Número 4", this);
		Carro competidor5 = new Carro("Número 5", this);
		
		competidor1.start();
		competidor2.start();
		competidor3.start();
		competidor4.start();
		competidor5.start();
		
		return competidor1;
	}
}
