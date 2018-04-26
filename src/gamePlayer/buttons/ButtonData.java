package gamePlayer.buttons;

import java.util.Map;

import data.GameDescriptionProvider;
import data.Serializer;
import engine.GamePart;
import gamePlayer.keyBindings.KeyInputDictionary;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public interface ButtonData {
	public void playGame(String file);
	public Stage getStage();
	public String getMostRecentFile();
	public String getCurrentGameName();
	public GamePart getGamePart();
	public void clearHighScores();
	public void addToRoot(Node node);
	public KeyInputDictionary getKeyBindings();
	public void toggleVolume();
	//public void toggleGameSounds(boolean setting);
	//public void toggleMusic(boolean setting);
	//public void setSoundLevel
	// public GameDescriptionProvider getGameDescriptionProvider();
	public void removeFromRoot(Node node);
	public Boolean getVolumeStatus();
	public void resumeGame();
	public void pauseGame();
}
