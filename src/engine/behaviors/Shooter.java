package engine.behaviors;

import java.util.Arrays;
import java.util.List;

import authoring.GameObject;
import engine.GameElement;
import engine.events.gameevents.AddElementEvent;
import engine.tests.ModelGameState2;

public class Shooter extends Behavior {
	
	private GameObject toShoot;
	private Double defaultVelocity;
	private Double distAway; // The distance away from the character the bullet is generated 
	
	public Shooter(GameElement ge, Double defaultVel, Double dist) {
		super(ge);
		defaultVelocity = defaultVel;
		distAway = dist;
	}
	
	public Shooter(GameElement ge) {
		this(ge, 30.0, 10.0);
		MandatoryBehavior mand = (MandatoryBehavior) ge.getBehavior(MandatoryBehavior.class);
		distAway = Math.sqrt(Math.pow(mand.getShape().getBoundsInLocal().getHeight(), 2.0) + Math.pow(mand.getShape().getBoundsInLocal().getWidth(), 2.0));
	}
	
	public void shoot(Double v, List<Double> direction) {
		MandatoryBehavior mand = (MandatoryBehavior) getParent().getBehavior(MandatoryBehavior.class);
		Double magDirection = Math.sqrt(Math.pow(direction.get(0), 2) + Math.pow(direction.get(1), 2));
		Double startx = mand.getX() + distAway * direction.get(0)/magDirection + mand.getShape().getBoundsInLocal().getWidth()/2;
		Double starty = mand.getY() + distAway * direction.get(1)/magDirection + mand.getShape().getBoundsInLocal().getHeight()/2;
		GameElement bullet = new ModelGameState2().getBullet(startx, starty, v, direction);
		getParent().addGameEvent(new AddElementEvent(bullet));
	}
	
	public void shootRight() {
		shoot(defaultVelocity, Arrays.asList(-1.0, 1.0));
	}
	
	public void shootLeft() {
		shoot(defaultVelocity, Arrays.asList(-1.0, 0.0));
	}
	
	public void shootUp() {
		shoot(defaultVelocity, Arrays.asList(0.0, 1.0));
	}
	
	public void shootDown() {
		shoot(defaultVelocity, Arrays.asList(0.0, -1.0));
	}
}
