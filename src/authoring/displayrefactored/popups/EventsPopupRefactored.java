package authoring.displayrefactored.popups;

import authoring.GameObject;
import authoring.displayrefactored.controllers.EventsPopupController;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

/**
 * @author August Ning
 *
 */
public class EventsPopupRefactored extends PopupRefactored {
	
	GameObject go;
	EventsPopupController epuc;
	HBox epuBox;
	
	private static final int xSize = 1260;
	private static final int ySize = 400;
	
	public EventsPopupRefactored(GameObject inGo) {
		super();
		go = inGo;
		epuc = new EventsPopupController(go);
		epuBox = new HBox();
		epuBox.setPadding(new Insets(10));
	    epuBox.setSpacing(8);
		epuBox.getChildren().addAll(epuc.getWindows());
		generatePopup();
		open(xSize, ySize);
	}

	@Override
	protected void generatePopup() {
		this.getPane().getChildren().add(epuBox);
	}

	@Override
	protected void mapButtons() {
		// no buttons are being mapped
	}

}
