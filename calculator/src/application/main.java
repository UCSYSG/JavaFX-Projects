package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class main extends Application {
	private double x = 0, y = 0;
	
	@Override
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("document.fxml"));
		Scene scene = new Scene(root);
		root.setOnMousePressed((MouseEvent event) -> {
			x = event.getSceneX();
			y = event.getSceneY();
		});
		
		root.setOnMouseDragged((MouseEvent event) -> {
			stage.setX(event.getSceneX() - x);
			stage.setY(event.getSceneY() - y);
			
		});
		
		scene.setFill(Color.TRANSPARENT);
		
		stage.setScene(scene);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.show();	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
