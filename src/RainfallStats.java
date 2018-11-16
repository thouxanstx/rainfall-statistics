import java.util.*;

public class RainfallStats {
	
	private final List<Double> rainfallStats = new ArrayList<>();
	
	public int getCount() {
		int rainfallStatsSize = rainfallStats.size();
		return rainfallStatsSize; 
	}

	public void addMeasurement(double measurement) throws InvalidRainfallException{
		if (measurement < 0) {
			throw new InvalidRainfallException("Invalid measurement: " + measurement);
		}
		rainfallStats.add(measurement);
	}

	public double getMean() { 
		if(rainfallStats.size()==0) throw new IllegalStateException(
				"There are no measurements to get the mean of");
		double mean = 0.0;
		for (int i = 0; i <rainfallStats.size(); i++) {
			double stats = rainfallStats.get(i);
			mean += stats/rainfallStats.size();
			
		}
		return mean;
	}

	public double getMax() {
		if(rainfallStats.size()==0) throw new IllegalStateException(
				"There are no measurements to get the max of");
		double max = rainfallStats.get(0);
		for(int i = 0; i <rainfallStats.size(); i++ ) {
			if(rainfallStats.get(i)> max) {
				max = rainfallStats.get(i);
			}
		}
		return max;
	}
}