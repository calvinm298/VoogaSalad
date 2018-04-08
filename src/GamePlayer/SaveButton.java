package GamePlayer;

import javafx.scene.control.Button;

public class SaveButton extends Button{
	ConcreteGamePlayer gamePlayer;
	
	public SaveButton(double x, double y, double width, double height, ConcreteGamePlayer gamePlayer) {
		this.setLayoutX(x);
		this.setLayoutY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.setText("save");
		this.gamePlayer = gamePlayer;
		setAction();
	}
	
	private void setAction() {
		this.setOnAction(event -> {
			//gamePlayer.saveGame();;
		});
	}
		

}
