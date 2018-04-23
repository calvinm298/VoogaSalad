package authoring;

import java.util.List;

import javafx.scene.image.ImageView;


public interface ObjectInfoObservable {
	GameObject getCurrentGameObject();
	List<GameObject> getInstances();
	ImageView getCurrentImage();
}
