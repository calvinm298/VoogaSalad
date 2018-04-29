package gamePlayer.buttons;

import java.io.File;
import java.nio.file.Paths;

import gamePlayer.ConcreteGamePlayer;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * button user presses to launch the game loader
 * @author jeffreyli, calvinma
 *
 */
public class LoadButton extends PlayerButtons {

	public LoadButton(double x, double y, double width, double height, ButtonData buttonData) {
		super(x, y, width, height, buttonData, "Load Game");
	}

	protected void setAction() {
		this.setOnAction(event -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("CHOOSE GAME");
			String currentPath = Paths.get(".").toAbsolutePath().normalize().toString() + "/data/gamedata/games";
			fileChooser.setInitialDirectory(new File(currentPath));

			File fileName = fileChooser.showOpenDialog(buttonData.getStage());
			String fileString = "No File Selected";
			if (fileName != null) {
				fileString = fileName.getPath();
			}

			buttonData.playGame(fileString, false);

		});

	}

}
