package problems;

public class Sphere extends Problem {
	
	public Sphere(int dimensions){
		super(dimensions);
	}
	
	public double getLowerBound(int dimensions){
		return -100;
	}
	
	public double getUpperBound(int dimensions){
		return 100;
	}
	
	public double evaluateSolution(double[] solution){
		double sumSquare = 0.0;
		for(int i = 0; i < solution.length; i++){
			sumSquare += (Math.pow(solution[i], 2.0)); 
		}
		return sumSquare;
	}
	
	public boolean isFitnessBetterThan(double currentSolutionFitness, double bestSolutionFitness){
		return currentSolutionFitness < bestSolutionFitness;
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}
	

}
	
