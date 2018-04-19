package engine.behaviors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import engine.GameElement;

public class Movable extends Behavior{
	
	public static final int X_LIST_POS = 0; // Position of X in direction 
	public static final int Y_LIST_POS = 1; // Position of Y in direction
	
	private Double xVel;
	private Double yVel;
	private boolean activate = true;
	
	public Movable(GameElement ge, Double vel, List<Double> dir) {
		super(ge);
		xVel = 0.0;
		yVel = 1.0;
		setVelocity(vel);
		if (dir.stream().reduce(0.0, (a, b) -> a + b) != 0) {
			setDirection(dir);
		} else {
			throw new IllegalArgumentException("Invalid Direction for " + ge.getIdentifier() + ": " + dir);
		}
	}
	
	public Movable (GameElement ge, Double xv, Double yv) {
		super(ge);
		xVel = xv; 
		yVel = yv;
	}
	
	public Movable(GameElement ge) {
		this(ge, 5.0, Arrays.asList(0.0, 1.0));
	}
	
	/*
	 * Moves the parent game element according to the time amount requested
	 */
	public void move(Double time) {
		if (activate) {
			MandatoryBehavior bge = (MandatoryBehavior) getParent().getBehavior(MandatoryBehavior.class);
			bge.setPosition(bge.getX() + xVel * time, bge.getY() + yVel * time);
		}
	}
	
	public void setactivity(boolean state) {
		activate = state;
	}
	
	/*
	 * Sets the direction for this element. Checks if the direction 
	 * is valid and normalizes it so move method works correctly
	 */
	public void setDirection(List<Double> dir) {
		Double v = getVelocity();
		setXVelocity(v * dir.get(0));
		setYVelocity(v * dir.get(1));
	}
	
	/*
	 * Sets the velocity according to what the other classes want. Checks if velocity is valid for this object 
	 */
	public void setVelocity (Double v) {
		xVel = getDirection().get(0) * v;
		yVel = getDirection().get(1) * v;
	}
	
	public void setXVelocity (Double xv) {
		xVel = xv;
	}
	
	public void setYVelocity (Double yv) {
		yVel = yv;
	}
	
	public Double getXVelocity () {
		return xVel;
	}
	
	public Double getYVelocity () {
		return yVel;
	}
	
	public Double getVelocity () {
		return Math.sqrt(Math.pow(xVel, 2) + Math.pow(yVel, 2));
	}
	
	
	public List<Double> getDirection() {
		return Arrays.asList(xVel / getVelocity(), yVel /getVelocity());
	}
	
}
