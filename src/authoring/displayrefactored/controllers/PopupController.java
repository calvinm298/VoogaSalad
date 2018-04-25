package authoring.displayrefactored.controllers;

import javafx.scene.layout.Pane;

public abstract class PopupController {
	protected abstract void initializeScreenComponents();
	
	protected abstract void setUpConnections();

	protected abstract void addToGUI(Pane pane);
	
	protected abstract void refreshView();
}
