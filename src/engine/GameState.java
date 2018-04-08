package engine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import engine.events.elementevents.ElementEvent;
import engine.events.gameevents.GameEvent;
import javafx.scene.shape.Shape;

public class GameState implements Iterable<GameElement>{
	private HashSet<GameElement> elements;
	private HashMap<String, String> gameproperties; 


	public List<ElementEvent> detectCollisions() {
		LinkedList<ElementEvent> events = new LinkedList<ElementEvent>();
		for (GameElement e1 : elements) {
			for (GameElement e2 : elements) {
				if (e1 != e2) {
					Shape intersect = Shape.intersect(e1.getImageView(), e2.getImageView());
					if (intersect.getBoundsInLocal().getWidth() != -1) {
						ElementEvent collision = new CollisionEvent(e1, e2);
						events.add(collision);
					}
				}
			}
		}

			
	}
	
	public void addGameElement(GameElement gameElement) {
		elements.add(gameElement);
	}
	
	public void removeGameElement(GameElement gameElement) {
		elements.remove(gameElement);
	}
	
	public List<Map<String, Integer>> getDisplayStates() {
		return null;
		
	}
	
	/**
	 * @returns a map containing general information about the game which is defined by the user. 
	 */
	protected Map<String,String> getGameProperties() {
		return gameproperties;
	}
	
	public List<GameEvent> updateElements(ElementEvent elementEvent) {
		List<GameEvent> gameEvents = elements.parallelStream()
				.map(c -> c.processEvent(elementEvent))
				.flatMap(List::stream)
				.collect(Collectors.toList());
		
		
		/*for (GameElement e1 : elements) {
			gameEvents.addAll(e1.processEvent(elementEvent));
		}*/
		return null;
	}

	@Override
	public Iterator<GameElement> iterator() {
		return elements.iterator();
	}

}
