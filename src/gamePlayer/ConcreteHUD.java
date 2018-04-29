package gamePlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ConcreteHUD extends Pane implements HUD {

	String gameName;
	Map<String, Object> info;
	private int xLabel = 0;
	private int yLabel = 0;
	List<Label> labelList;

	public ConcreteHUD(String name) {
		gameName = name;
		info = new HashMap<>();
		labelList = new ArrayList<>();
		setupPane();
	}

	/**
	 * setting up front end JavaFX of the pane
	 */
	//
	private void setupPane() {
		this.setLayoutX(30);
		this.setLayoutY(30);
		this.setWidth(800);
		this.setHeight(650);

		setupHUDText();
	}

	private void setupHUDText() {
		yLabel = 0;
		xLabel = 0;
		this.getChildren().removeAll(labelList);
		labelList.clear();
		setUpName();

		for (String label : info.keySet()) {
			if ((xLabel + 100) > 900) {
				xLabel = 0;
				yLabel = yLabel + 25;
			}
			Label text = new Label(label + ": " + info.get(label).toString());
			//text = new Label("hi");

			text.setTextFill(Color.WHITE);
			text.setLayoutX(xLabel);
			xLabel = xLabel + 150;
			text.setLayoutY(yLabel);
			text.setFont(new Font(20));
			this.getChildren().add(text);
			labelList.add(text);
			System.out.println(labelList);
			
		}
	}

	private void setUpName() {
		Label nameText = new Label(gameName);
		nameText.setTextFill(Color.BLACK);
		nameText.setLayoutX(xLabel);
		nameText.setLayoutY(yLabel - 25);
		nameText.setFont(new Font(20));
		this.getChildren().add(nameText);
	}

	@Override
	public void updateInfo(Map<String, Object> info) {
		this.info = info;
		setupHUDText();
	}

}
