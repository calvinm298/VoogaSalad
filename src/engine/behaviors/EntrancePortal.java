package engine.behaviors;

import java.util.List;

import authoring.groovy.GroovyMethod;
import engine.GameElement;
import engine.actions.ChangeLevel;
import engine.events.elementevents.CollisionEvent;
import engine.events.gameevents.ChangePartEvent;
import engine.events.gameevents.ResetLevelEvent;

public class EntrancePortal extends Behavior{
	private boolean active;
	private String partToChange;
	private List<String> resetLevels;
	private int portalID;
<<<<<<< HEAD
	private Double portalTime = 0.0;
=======
	
	
>>>>>>> tn74
	public EntrancePortal (GameElement ge, boolean active, String partToChange, List<String> resetLevels, int portalID) {
		super(ge);
		this.active = active;
		this.partToChange = partToChange;
		this.resetLevels = resetLevels;
		this.portalID = portalID;
	}
	
	public EntrancePortal(GameElement ge) {
		super(ge);
	}
	
	@GroovyMethod
	public void runPortal() {
		if (active) {
			System.out.println(1);
			changeLevel();
			resetLevels();
		}
	}
	
	public void disableTemp() {
		portalTime = 5.0;
		active = false;
	}
	
	public void reduceDisableTime(Double time) {
		portalTime-= time;
		if (portalTime<0) {
			active = true;
		}
		
	}
	
	public void changeLevel() {
		if (active) {
			getParent().addGameEvent(new ChangePartEvent(partToChange, portalID));
		}
		
	}
	
	public void resetLevels() {
		for (String levelToReset : resetLevels) {
			getParent().addGameEvent(new ResetLevelEvent(levelToReset));
		}
	}
	
	@Override
	protected void addDefaultBehavior() {
		getParent().addEventResponse(new CollisionEvent(getParent(), CollisionEvent.ALL_SIDES, new GameElement("Mario"), CollisionEvent.ALL_SIDES), new ChangeLevel());
	}
}
