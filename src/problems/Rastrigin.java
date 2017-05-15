package problems;

public class Rastrigin extends Problem{
	public Rastrigin(int dimensions){
		super(dimensions);
	}
	
	public void init(){
		//DO NOTHING
	}
	
	public double getLowerBound(int dimension){
		return -5.12;
	}
	
	public double getUpperBound(int dimension){
		return 5.12;
	}
	
	public double evaluateSolution(double[] solution){
		double fitness;
		double auxSum = 0;
		int i;
		
		for(i = 0; i < this.dimensions; i++){
			auxSum += ((solution[i] * solution[i]) - 10 * Math.cos((2 * Math.PI * solution[i]))); 
		}
		
		fitness = (10 * (i + 1)) + auxSum;
		return fitness;
	}
	
	public boolean isFitnessBetterThan(double currentSolutionFitness,
			double bestSolutionFitness){
		return currentSolutionFitness < bestSolutionFitness;
	}
}
