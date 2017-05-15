package algorithm;

public class FireFly {
	
	 public double[] position;
	 public double[] bestPosition;
	 public double error;
	 public double beta;
	 
	 public FireFly( double[] position){
		this.position = position;
		this.bestPosition = position;
	 }

	public double[] getBestPosition() {
		return bestPosition;
	}

	public void setBestPosition(double[] bestPosition) {
		this.bestPosition = bestPosition;
		
	}

	public double[] getPosition() {
		return position;
	}

	public void setPosition(double[] position) {
		this.position = position;
	}

	public double getError() {
		return error;
	}

	public void setError(double error) {
		this.error = error;
	}

	public double getIntensity() {
		return beta;
	}

	public void setIntensity(double intensity) {
		this.beta = intensity;
	}
}
