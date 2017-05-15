package problems;

public class Rosenbrock extends Problem{
	public Rosenbrock(int dimensions){
		super(dimensions);
	}
	
	public void init(){
		//DO NOTHING
	}
	
	public double getLowerBound(int dimensions){
		return -30;
	}
	
	public double getUpperBound(int dimensions){
		return 30;
	}
	
	public double evaluateSolution(double[] solution){
		double fitness = 0;
		
		for(int i = 0; i < this.dimensions -1; i++){
			fitness += 100 * Math.pow((solution[i] +1) - (solution[i] * solution[i]), 2.0)
					+ Math.pow(1 - solution[i], 2.0);
		}
		return fitness;
	}
	
	public boolean isFitnessBetterThan(double currentSolutionFitness,
			double bestSolutionFitness) {
		return currentSolutionFitness < bestSolutionFitness;
	}
	
}
