

/**
 * Celestial Body class for NBody
 * @author ola
 *
 */
public class CelestialBody {
	

	/**	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	
	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;
	
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		// TODO: complete constructor
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		
		// TODO: complete constructor
		myXPos = b.getX();
		myYPos = b.getY();
		myXVel = b.getXVel();
		myYVel = b.getYVel();
		myMass = b.getMass();
		myFileName = b.getName();
	}

	public double getX() {
		// TODO: complete method
		return myXPos;
	}
	public double getY() {
		// TODO: complete method
		return myYPos;
	}
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}
	
	public double getMass() {
		// TODO: complete method
		return myMass;
	}
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		double a = Math.pow(myXPos - b.getX(), 2) + Math.pow(myYPos - b.getY(),2);
		return Math.sqrt(a);
	}

	public double calcForceExertedBy(CelestialBody p) {
		// TODO: complete method
		double G = 6.67e-11;
		double division = G * ((p.getMass()*myMass)/(Math.pow(calcDistance(p),2))) ;
		return division;
	}

	public double calcForceExertedByX(CelestialBody p) {
		// TODO: complete method
		double dx = (p.getX()- myXPos);
		double F = calcForceExertedBy(p);
		double r = calcDistance(p);
		return ((F*dx)/r);
	}
	public double calcForceExertedByY(CelestialBody p) {
		// TODO: complete method
		double dx = (p.getY()- myYPos);
		double F = calcForceExertedBy(p);
		double r = calcDistance(p);
		return ((F*dx)/r);
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double net = 0.0;
		for (CelestialBody b : bodies) { 
			if (! b.equals(this)) {
				net = net + calcForceExertedByX(b);
				
			}
		}
		return net;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		// TODO: complete method
		double net = 0.0;
		for (CelestialBody b : bodies) { 
			if (! b.equals(this)) {
				net = net + calcForceExertedByY(b);		
			}
		}
		return net;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		double ax = (xforce/myMass);
		double ay = (yforce/myMass);
		double nvx = (myXVel + deltaT*ax);
		double nvy = (myYVel + deltaT*ay);
		double nx = (myXPos + deltaT*nvx);
		double ny = (myYPos + deltaT*nvy);
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;
		
		
		// TODO: complete method
	}

	public void draw() {
		// TODO: complete method
		StdDraw.picture(myXPos, myYPos, "images/"+myFileName);
	}
}
