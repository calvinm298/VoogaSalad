package engine;

import java.util.ArrayList;
import java.util.List;

import engine.behaviors.ExitPortal;
import engine.behaviors.MandatoryBehavior;

public class GameState {
	private List<GameLevel> gameLevels;
	private GameLevel currentGameLevel;
	private final double gameSpeed = 2;
	private String gameName;
	
	private List<GameElement> addToDisplay;
	private List<GameElement> removeFromDisplay;

	public GameState(String gameName) {
		this.gameName = gameName;
		gameLevels = new ArrayList<>();
		addToDisplay = new ArrayList<>();
		removeFromDisplay = new ArrayList<>();
	}
	
	public void addToDisplay (GameElement ge) {
		addToDisplay.add(ge);
	}
	
	protected List<GameElement> getAddToDisplay() {
		return addToDisplay;
	}
	
	protected void clearAddToDisplay() {
		addToDisplay.clear();
	}
	
	public void removeFromDisplay (GameElement ge) {
		removeFromDisplay.add(ge);
	}
	
	protected List<GameElement> getRemoveFromDisplay() {
		return removeFromDisplay;
	}
	
	protected void clearRemoveFromDisplay() {
		removeFromDisplay.clear();
	}
	
	protected double getGameSpeed() {
		return gameSpeed;
	}
	
	public GamePart getCurrentGamePart() {
		return currentGameLevel.getCurrentGamePart();
	}
	
	public void changeCurrentGamePart(String newPartID, int portalID) {
		for (GameLevel gl : gameLevels) {
			for (GamePart newGamePart : gl.getGameParts()) {
				if(newGamePart.getGamePartID().equals(newPartID)) {
					GameElement mainCharacter = this.getCurrentGamePart().getMainCharacter();
					this.getCurrentGamePart().removeGameElement(mainCharacter);
					
					for (GameElement element : this.getCurrentGamePart().getElements()) {
						removeFromDisplay(element);
					}
					
					setCurrentGameLevel(gl);
					gl.setCurrentGamePart(newGamePart);
					for (GameElement element : this.getCurrentGamePart().getElements()) {
						if (element.hasBehavior(ExitPortal.class)) {
							ExitPortal exitP = (ExitPortal) element.getBehavior(ExitPortal.class);
							if (exitP.getPortalID() == portalID) {
								System.out.println("exit portal matches entrance portal id: " + portalID);
								mainCharacter.setPosition(element.getPosition());
								MandatoryBehavior mb = (MandatoryBehavior) element.getBehavior(MandatoryBehavior.class);
								mb.setPosition(mb.getX()-30, mb.getY());
								break;
							}
						}
					}
					this.getCurrentGamePart().addGameElement(mainCharacter);
					for (GameElement element : this.getCurrentGamePart().getElements()) {
						addToDisplay(element);
					}
					
				}
			}
		}
	}
	
	protected void setCurrentGameLevel(GameLevel gl) {
		currentGameLevel = gl;
	}
	
	protected GameLevel getCurrentGameLevel() {
		return currentGameLevel;
	}
	
	protected boolean containsLevel(String levelID) {
		return gameLevels.stream().anyMatch(gl -> gl.getGameLevelID().equals(levelID));
	}
	
	protected GameLevel getLevel(String levelID) {
		for (GameLevel gl : gameLevels) {
			if (gl.getGameLevelID().equals(levelID))
				return gl;
		}
		System.out.println("ERROR: Game Level Not Found");
		return null;
	}
	
	protected void addLevel(String levelID) {
		gameLevels.add(new GameLevel(levelID));
	}
}
