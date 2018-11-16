import java.io.*;

public class RainfallProgram {
	public static void main(String[] args) throws IOException {
		BufferedReader keyboard = new BufferedReader(
			new InputStreamReader(System.in)
		);
		
		RainfallStats stats = new RainfallStats();
		System.out.println("Enter rainfall measurements (in mm), or \"end\" to stop.");
		
		while(true) {
			
				System.out.print("> ");
				String line = keyboard.readLine();
				if("end".equals(line)) {
					break;
				}
				try {
					double measurement = Double.parseDouble(line);
					stats.addMeasurement(measurement);
				}catch(NumberFormatException ex){
					System.out.println("Invalid measurement(enter \"end\" to stop).");
				}catch(InvalidRainfallException ex ) {
					System.out.println("Measurements can't be negative!");
				}
			}
		
		System.out.println(stats.getCount() + " measurement(s) entered.");
		if(stats.getCount()!=0) {
			System.out.println("Mean rainfall: " + stats.getMean() + " mm");
			System.out.println("Maximum rainfall: " + stats.getMax() + " mm");
		}
	}
}