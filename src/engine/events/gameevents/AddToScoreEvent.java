package engine.events.gameevents;

import engine.GamePart;
import engine.GameState;
import engine.behaviors.MainCharacter;

public class AddToScoreEvent extends GameEvent {
	public int score;
	public int characterID;
	
	public AddToScoreEvent(int characterID, int score) {
		this.characterID = characterID;
		this.score = score;
	}

	@Override
	public void execute(GameState gameState) {
		((MainCharacter)gameState.getCurrentGamePart().getMainCharacter().getBehavior(MainCharacter.class)).addToScore(score);
	}

}
