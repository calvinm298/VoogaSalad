package authoring.displayrefactored.controllers;

import authoring.GameObject;
import authoring.GameObjectAdder;
import authoring.GameScene;
import authoring.SceneManager;
import authoring.displayrefactored.authoringuicomponents.LevelPanelRefactored;
import data.AudioManager;
import data.ImageManager;
import data.propertiesFiles.ResourceBundleManager;
import javafx.scene.layout.Pane;

/**
 * 
 * @author Edward Zhuang
 *
 */
public class LevelPanelController extends Controller implements GameObjectAdder {

	SceneManager sceneManager;
	LevelPanelRefactored levelPanelRefactored;
	ObjectInfoPanelController objectInfoPanelController;
	GameViewWindowController gameViewWindowController;
	AudioController audioController;
	
	private static final String MANDATORY_BEHAVIOR_NAME = "MandatoryBehavior";
	
	public LevelPanelController(SceneManager sceneManager, ImageManager imageManager, AudioManager audioManager) {
		super(imageManager);
		this.sceneManager = sceneManager;
		objectInfoPanelController = new ObjectInfoPanelController(this.sceneManager.getCurrentScene(),getImageManager());
//		System.out.println("this is current scene: " + this.sceneManager.getCurrentScene());
		gameViewWindowController = new GameViewWindowController(this.sceneManager.getCurrentScene(),getImageManager());
		audioController = new AudioController(this.sceneManager.getCurrentScene(), getImageManager(), audioManager);
		
	}
	
	public ObjectInfoPanelController getObjectInfoPanelController() {
		return objectInfoPanelController;
	}
	
	public GameViewWindowController getGameViewWindowController() {
		return gameViewWindowController;
	}
	
	public AudioController getAudioController() {
		return audioController;
	}
	
	@Override
	protected void initializeScreenComponents() {
		levelPanelRefactored = new LevelPanelRefactored(this);
	}

	@Override
	protected void setUpConnections() {
		sceneManager.addObserver(levelPanelRefactored);
	}

	@Override
	protected void addToGUI(Pane pane) {
		int x = ResourceBundleManager.getPosition("LEVELPANEL_X");
		int y = ResourceBundleManager.getPosition("LEVELPANEL_Y");
		levelPanelRefactored.attachToPane(pane, x, y);	
	}
	
	@Override
	protected void refreshView() {
	}
	
	public void setCurrentSceneName(String name) {
		sceneManager.setCurrentSceneName(name);
	}
	
	public void setCurrentLevelId(String id) {
		sceneManager.setCurrentLevelId(id);
	}
	
	public void addLevel(String name, String id) {
		GameScene scene = sceneManager.makeScene(name, id);
		setLevel(scene.getName());
//		levelPanelRefactored.updateLevelDropdown(level - 1, scene);
		
	}
	
	public void setLevel(String name) {
		sceneManager.setCurrentScene(name);
		updateMyControllers(sceneManager.getCurrentScene());
	}
	
	private void updateMyControllers(GameScene gameScene) {
		objectInfoPanelController.setGameScene(gameScene);
		gameViewWindowController.setGameScene(gameScene);
		audioController.setGameScene(gameScene);
	}

	@Override
	public void addToCurrentScene(GameObject gameObject) {
		// TODO Auto-generated method stub
		sceneManager.getCurrentScene().addObject(gameObject);
	}
}
