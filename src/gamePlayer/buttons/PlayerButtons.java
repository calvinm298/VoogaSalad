package gamePlayer.buttons;

import data.propertiesFiles.ResourceBundleManager;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;

public abstract class PlayerButtons extends Button {
	
	private static final int fontSize = 12;
	protected ButtonData buttonData;
	private String font = "Din Alternate";

	public PlayerButtons(double x, double y, double width, double height, ButtonData buttonData, String text) {

		this.setLayoutX(x);
		this.setLayoutY(y);
		this.setMinWidth(width);
		this.setHeight(height);
		this.setFont(Font.font(font, 12));
		this.buttonData = buttonData;
		this.setOpacity(0.8);
		this.setText(text);
//		this.setStyle("     -fx-border-color: transparent;\r\n" + "    -fx-background-color: transparent;\r\n");
		setAction();

	}

	abstract protected void setAction();

}
