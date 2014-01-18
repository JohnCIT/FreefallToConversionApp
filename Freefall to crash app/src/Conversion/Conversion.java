package Conversion;

public class Conversion {

	final static double GRAVITY = 9.8;
	final static int MASS 		= 87;
	
		
	
	/**
	 * Return the free fall height
	 * Formula = height = PotentialEnergy / mass * gravity 
	 * @return free fall height
	 */
	public static double kmhToFreeFallHeight(double kmh) {
		kmh = convertKmHToMps(kmh);//Convert to meters so everything is in the same units
		double kineticEnergy = getKeneticEnergy(kmh);
		return kineticEnergy / (GRAVITY * MASS);
	}
	
	
	/**
	 * Return the kmh speed
	 */
	public static double heightToKmh(double height) {
		double potEng 	= getPotentialEnergy(height);
		double velocity = getVelocitySquared(potEng); 
		return convertMPSToKMH(velocity);
	}
	
		
	
	
	
	
	
	//////////////////////////////////////////////////////private methods///////////////////////////
	
	
	
	
	/**
	 * Convert kilometres to metres
	 * @return the meters per second
	 */
	private static double convertKmHToMps(double km) {
		return km * 0.277778;
	}
	
	
	
	/**
	 * Convert metres a second to km
	 * 1 mps = 3,6 kmh
	 */
	private static double convertMPSToKMH(double mps) {
		return mps * 3.6;
	}
	
	
	
	/**
	 * Get the kinetic energy
	 * Formula 1/2mv2 m = mass v = velocity
	 * @return kinetic energy
	 */
	private static double getKeneticEnergy(double velocity) {
		return 0.5 *  MASS * (velocity * velocity);
	}
	
	
	
	/**
	 * Get potential energy
	 * Formula = PE = mgh
	 * m = Mass, g = gravity, h = height
	 */
	private static double getPotentialEnergy(double height) {
		return MASS * GRAVITY * height;
	}
	
	
	/**
	 * Get the velocity from using the potential energy
	 * Velocity^2 = PE / (0.5 * mass)
	 * @return The velocity, in metres a second
	 */
	private static double getVelocitySquared(double PE) {
		return Math.sqrt(PE/ (0.5 * MASS));
	}
	
	
	
	
	
	
}
