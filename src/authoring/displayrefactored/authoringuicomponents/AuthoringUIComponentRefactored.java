package authoring.displayrefactored.authoringuicomponents;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * 
 * @author Edward Zhuang
 *
 * Abstract class for all AuthoringUIComponents. Provides borderpane.
 */
public abstract class AuthoringUIComponentRefactored {

	private BorderPane borderPane;
	
	/**
	 * Constructor that creates borderpane and creates FX components of subclass
	 */
	public AuthoringUIComponentRefactored() {
		borderPane = new BorderPane();
		generateComponent();
	}
	
	protected abstract void generateComponent();
	
	/**
	 * Protected getter for borderPane which subclass can use to attach FX components onto
	 * @return borderPane
	 */
	protected BorderPane getBorderPane() {
		return borderPane;
	}
	
	/**
	 * Used by Authoring Environment to position this class' borderpane onto a larger overall GUI pane. This way, no public getter is needed.
	 * @param pane
	 * @param xPosition
	 * @param yPosition
	 */
	public void attachToPane(Pane pane, int xPosition, int yPosition) {
		borderPane.setLayoutX(xPosition);
		borderPane.setLayoutY(yPosition);
		pane.getChildren().add(borderPane);
	}
	
}
