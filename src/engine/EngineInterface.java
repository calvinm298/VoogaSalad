package engine;

import javafx.scene.SubScene;
import javafx.scene.input.KeyCode;

public interface EngineInterface {

	public void close();
	public SubScene getDisplay();
	public void handleKeyInput(KeyCode code);
	public void handleMouseInput(double x, double y);
	public void setVolume(double newVolume);
	
}
