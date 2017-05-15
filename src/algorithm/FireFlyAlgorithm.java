package algorithm;

import java.util.Random;
import problems.Problem;

public class FireFlyAlgorithm {
	public double bestFitness;
	private double globalBestPosition[];

	private FireFly[] fireFlies;
	private Random rand;
	private Problem problema;
	private double[] bestPosition;
	//indice de absorção de luz
	public double gama = 0.2;
	//brilhosidade
	private double beta0;
	
	public FireFlyAlgorithm(Problem problem){
		rand = new Random();
		this.problema = problem;
		setBeta0(0.4);
	}
	
	public double[] getBestPosition() {
		return bestPosition;
	}

	public void setBestPosition(double[] bestPosition) {
		this.bestPosition = bestPosition;
	}

	public double getBeta0() {
		return beta0;
	}

	public void setBeta0(double beta0) {
		this.beta0 = beta0;
	}

	public void initializeSwarm(){
		this.fireFlies = new FireFly[Parameters.SCHOOL_SIZE];
		double position[];
		for(int i = 0; i < fireFlies.length; i++){
			position = createRandomPosition(problema.getDimensions());
			this.fireFlies[i] = new FireFly(position);
		}
	}
	
	public double[] createRandomPosition(int dimensions){

		double position[] = new double[dimensions];
		for (int i = 0; i < position.length; i++) {
			position[i] = problema.getUpperBound(0)/2 + (problema.getUpperBound(0) - 
					problema.getUpperBound(0)/2)*rand.nextDouble();
		}
		return validatePosition(position);
	}
	
	private double createRandomNumberBrilhoMinimo(double min, double max) {
		// TODO Auto-generated method stub
		return min + (max - min)* rand.nextDouble();
	}
	
	 private double distance(double[] a, double[] b) {
	        double diff_square_sum = 0.0;
	        for (int i = 0; i < a.length; i++) {
	            diff_square_sum += (a[i] - b[i]) * (a[i] - b[i]);
	        }
	        return Math.sqrt(diff_square_sum);
	  }
	
	private double updateGlow(double distance){
		
		double betaAux;
		betaAux = Math.exp(-this.gama * distance);
		return betaAux;
	}
	
	private double[] updatePosition(double[] p1, double[] p2, double beta){
		double aux[] = new double[p1.length];
		
		for(int i = 0; i < p1.length; i++){
			aux[i] = p1[i] + beta*(p2[i] - p1[i]) + Parameters.ALFA*(rand.nextDouble() - 0.5);
		}
				
		return aux;
	}
	
	public void updateBeta0(){
		double fatorDeDecaimento = 0.3/Parameters.ITERACTIONS;
		setBeta0(getBeta0() - fatorDeDecaimento);
	}
	
	public void updateFitness(){
		
	}
	
	
	public void Busca(){
		
		initializeSwarm();
		double distance = 0.0;
		double[] newPosition;
		globalBestPosition = fireFlies[0].getBestPosition().clone();
		for(int n = 0; n < Parameters.ITERACTIONS; n++){
			for(int i = 0; i < fireFlies.length; i++){
				for(int j = 0; j < fireFlies.length; j++){
					if(fireFlies[j].beta > fireFlies[i].beta){
						distance = distance(fireFlies[i].getPosition(), fireFlies[j].getPosition());
						fireFlies[i].setIntensity(updateGlow(distance));
						newPosition = updatePosition(fireFlies[i].getPosition(), fireFlies[j].getPosition(), fireFlies[i].getIntensity());
						fireFlies[i].setPosition(newPosition);
						
					}else{
						fireFlies[i].setPosition(createRandomPosition(Parameters.DIMENSIONS));
					}
				}
				//atualiza fitness
				bestFitness = getBestFitness();
				System.out.println(bestFitness);
			}
			
		}
		updateGlobalBest();
	}
	
public void updateGlobalBest(){

		for (int i = 1; i < fireFlies.length; i++) {
	
			if(problema.isFitnessBetterThan(problema.evaluateSolution(fireFlies[i].
					getBestPosition()), problema.evaluateSolution(globalBestPosition))){
					globalBestPosition = fireFlies[i].getBestPosition().clone();

			}
		}
	}
		
	public double getBestFitness(){
		
		return problema.evaluateSolution(globalBestPosition);
	}
	
	public double[] validatePosition(double position[]){
		for(int j = 0; j < position.length; j++){
			if(position[j] > problema.getUpperBound(j)){
				position[j] = problema.getUpperBound(j);
			}else if(position[j] < problema.getLowerBound(j)){
				position[j] = this.problema.getLowerBound(j);
			}
		}
		
		return position;
	}
	
}
