package engine.behaviors;

import java.util.Arrays;
import java.util.List;

import authoring.groovy.GroovyMethod;
import engine.GameElement;
import javafx.geometry.Bounds;
import javafx.scene.input.KeyCode;

public class MainCharacter extends Behavior{
	
	int gamelives;
	List<KeyCode> defaultmoves = Arrays.asList();
	boolean xscroll = false;
	boolean yscroll = false;
	
	
	public MainCharacter(GameElement ge, int gamelives, boolean xscroll, boolean yscroll) {
		super(ge);
		this.xscroll = xscroll;
		this.yscroll = yscroll;
		this.gamelives = gamelives;
		
	}
	
	public MainCharacter(GameElement ge) {
		super(ge);
		gamelives = 1;
	}
	
	@GroovyMethod
	public int getLives() {
		return gamelives;
	}
	
	@GroovyMethod
	public List<KeyCode> getmoveKeys() {
		return defaultmoves;
	}
	
	@GroovyMethod
	public boolean isXscroll() {
		return xscroll;
	}
	
	@GroovyMethod
	public boolean isYScroll() {
		return yscroll;
	}
	
	
	public List<Double> getImageViewOffset(Double width, Double height) {
		List<Double> offset = Arrays.asList(0.0,0.0);
		MandatoryBehavior mc_mandatory = (MandatoryBehavior) getParent().getBehavior(MandatoryBehavior.class);
		Double mc_width_os = mc_mandatory.getShape().getBoundsInLocal().getWidth()/2;
		Double mc_height_os = mc_mandatory.getShape().getBoundsInLocal().getHeight()/2;
		if (xscroll) {
			offset.set(0, width/2 - mc_mandatory.getX() - mc_width_os);
		}
		if (yscroll) {
			offset.set(1, height/2 - mc_mandatory.getY() - mc_height_os);
		}
		return offset;
	}
}
