package authoring.display.eventspopup;

import java.util.ArrayList;
import java.util.List;

import authoring.Behavior;
import authoring.Event;
import authoring.Game;
import authoring.GameObject;
import javafx.scene.layout.VBox;

public class EventsPopUpController {

	private Game game;
	private GameObject go;
	
	private EventsWindow eventsWindow;
	private TriggerWindow triggerWindow;
	private BehaviorsWindow behaviorsWindow;
	private MFWindow mfWindow;
	private ResponseWindow responseWindow;
	private GroovyWindow groovyWindow;
	
	public EventsPopUpController(Game myGame, GameObject myGo) {
		game = myGame;
		go = myGo;
		
		eventsWindow = new EventsWindow(this, game, go);
		triggerWindow = new TriggerWindow(this, game, go);
		behaviorsWindow = new BehaviorsWindow(this, game, go);
		mfWindow = new MFWindow(this, game, go);
		responseWindow = new ResponseWindow(this, game, go);
		groovyWindow = new GroovyWindow(this, game, go);
	}
	
	public Event getCurrEvent() {
		return eventsWindow.getCurrEvent();
	}
	public Behavior getCurrBehavior() {
		return behaviorsWindow.getCurrBehavior();
	}
	public boolean validEvent() {
		return eventsWindow.validEvent();
	}
	public void concatenateString(String stringToAdd) {
		groovyWindow.concatenateString(stringToAdd);
	}
	public List<VBox> getWindows() {
		List<VBox> windows = new ArrayList<>();
		windows.add(eventsWindow);
		windows.add(triggerWindow);
		windows.add(responseWindow);
		windows.add(behaviorsWindow);
		windows.add(mfWindow);
		windows.add(groovyWindow);
		return windows;
	}
	public void updateFromEvent(Event e) {
		responseWindow.createVBox();
		behaviorsWindow.createVBox();
		mfWindow.createVBox();
		eventsWindow.updateEventList();
	}
}
