package engine.authouringconversion;

import java.util.Map.Entry;

import authoring.AuthBehavior;
import authoring.Event;
import authoring.GameObject;
import authoring.GameScene;
import engine.GameElement;
import engine.GamePart;
import engine.actions.Action;
import engine.behaviors.Behavior;
import engine.events.elementevents.ElementEvent;

public class Printer {
	
	public void printState(GamePart part ) {
		System.out.println("GameState: " + part);
		part.getElements().stream().forEach(el -> {printGameElement(el); System.out.println();});
	}
	
	public void printScene (GameScene scene) {
		System.out.println("Printing Scene: " + scene.getName());
		for (GameObject go: scene.getMyObjects()) {
			printGameObject(go);
		}
		System.out.println("Finished printing scene");
	}
	
	private void printEngineBehavior(Behavior b) {
		System.out.println("Behavior: " + b.getClass().getCanonicalName());
		System.out.println(b.reportProperties());
	}
	
	public void printAuthBehavior(AuthBehavior authB) {
		System.out.println("AuthBehavior: " + authB);
		authB.getProperties().stream() 
		.forEach(prop -> System.out.println(prop));
	}
	
	public void printGameElement(GameElement ge) {
		System.out.println("**********************");
		System.out.println("Game Element: " + ge);
		for (Behavior b: ge.getAllBehaviors()) {
			System.out.println();
			printEngineBehavior(b);
		}
		for (Entry<ElementEvent, Action> entry: ge.getResponder().getResponses().entrySet()) {
			System.out.println("Action Map: " + entry.getKey());
		}
	}
	
	
	
	public void printGameObject (GameObject go) {
		System.out.println("--------------------------");
		System.out.println("GameObject toString: " + go);
		System.out.println("Game Object Behaviors: " + go.getBehaviors() + " \n");
		for (AuthBehavior authB: go.getBehaviors()) {
			printAuthBehavior(authB);
			System.out.println();
		}
		
		for (Event ev: go.getEvents()) {
			printEvent(ev);
			System.out.println();
		}
	}
	
	public void printEvent(Event ev) {
		System.out.println(ev);
	}
}
