package engine;

import java.util.List;

import data.GameLoader;
import engine.events.elementevents.ElementEvent;
import engine.events.elementevents.KeyInputEvent;
import engine.events.elementevents.MouseInputEvent;
import engine.events.elementevents.TimeEvent;
import engine.tests.ModelGameState;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Engine /*extends Application*/ {
	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	/*public static final Paint BACKGROUND = Color.WHITE;*/
	
	private Timeline animation;
	
	private Pane enginePane = new Pane();
	private GameState gameState;
	private DisplayState displayState;
	private EventManager2 eventManager;
	
	private String musicPath = "data/music/WiiShopChannelMusic.mp3";
	
	public Engine(String gamePath) {
		//EngineRunner engineRunner = new EngineRunner(gamePath);
		//GameLoader loader = new GameLoader(gamePath);
		
		ModelGameState modelGameState = new ModelGameState(); 
		gameState = modelGameState.getState();
		displayState = modelGameState.getDisplay();
		eventManager = new EventManager2(gameState, this);
		
		new AudioPlayer(musicPath);
		startAnimation();
	}
	
	public Pane getDisplay() {
		return enginePane;
	}
	
	private void startAnimation() {
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
                e -> timeStep(SECOND_DELAY));
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    }
	/*
	private Scene setupLevel (int width, int height, Paint background) {
		Group root = new Group();
		Scene scene = new Scene(root, width, height, background);
		
		root.getChildren().add(enginePane);
		
		scene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
        scene.setOnMouseClicked(e -> handleMouseInput(e.getX(), e.getY())); 
        
    	return scene;

    }*/
	
	public List<ElementEvent> handleKeyInput(KeyCode code) {
		eventManager.processElementEvent(new KeyInputEvent(code));
		return null;
	}
	
	public Object handleMouseInput(double x, double y) {
		eventManager.processElementEvent(new MouseInputEvent(x,y));
		return null;
	}
	
	public void timeStep (double elapsedTime) {
		double gameSteps = elapsedTime*gameState.getGameSpeed();
		gameState.incrementGameTime(gameSteps);
    	eventManager.processElementEvent(new TimeEvent(gameSteps));
    	displayState.updateImageElements();
    	updateDisplay(displayState.newElements, displayState.removeElements);
    }

	protected void updateDisplay(List<ImageElement> newElements, List<ImageElement> removeElements) {
		for (ImageView e:newElements) {
			enginePane.getChildren().add(e);
		}
		newElements.clear();
		
		for (ImageView e:removeElements) {
			enginePane.getChildren().remove(e);
		}
		removeElements.clear();
	}
	
	/*public static void main(String[] args) {
		Application.launch(args);
		//System.out.println("Hello World");
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(setupLevel(900, 590, BACKGROUND));
		stage.show();
		
		ModelGameState modelGameState = new ModelGameState(); 
		gameState = modelGameState.getState();
		displayState = modelGameState.getDisplay();
		eventManager = new EventManager2(gameState, this);
		
		startAnimation();
	}*/
}
