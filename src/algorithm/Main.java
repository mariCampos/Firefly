package algorithm;

import problems.Sphere;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sphere problema = new Sphere(30);
		//Rosenbrock problema = new Rosenbrock(30);
		//Ackley problema = new Ackley(30); //MELHOR RESULTADO OBTIDO
		//Rastrigin problema = new Rastrigin(30);
		
		FireFlyAlgorithm swarm = new FireFlyAlgorithm(problema);
		
		swarm.Busca();
	}

}
