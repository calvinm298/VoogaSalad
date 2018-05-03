package display.buttonevents;

import java.util.List;

import authoring.GameObject;
import authoring.display.popups.eventspopup.TWCPopup;
import authoring.display.popups.eventspopup.TriggerWindow;

public class TriggerCollisionPress implements ButtonEvent {
	
	private TriggerWindow tw;
	private List<GameObject> allGos;

	public TriggerCollisionPress(TriggerWindow intw, List<GameObject> inGos) {
		tw = intw;
		allGos = inGos;
	}

	@Override
	public void pressed() {
		new TWCPopup(tw, allGos);
	}

}
