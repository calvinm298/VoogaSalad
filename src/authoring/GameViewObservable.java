package authoring;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public interface GameViewObservable {

	List<GameObject> getMyObjects();
	
	List<SceneBackgroundImageSerializable> getBackgroundImageSerializables();
}