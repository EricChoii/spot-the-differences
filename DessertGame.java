import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
// to be used through this activity
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Pos;
import java.util.Random;
import javafx.application.Platform;

public class DessertGame extends Application {
    private int score = 0;
    
    private void randomizeButtonPositions(Random random, Button[] btn_arr){
	for (Button btn : btn_arr){
	    btn.setLayoutX(random.nextInt(600));
	    btn.setLayoutY(random.nextInt(400));
	}
    }
    
    @Override
    public void start(final Stage stage) {
	Label label = new Label("Score: " + score);

	Button quitButton = new Button("Exit");
	quitButton.requestFocus();
	quitButton.setOnAction(event -> { Platform.exit(); });

	Button[] btns = new Button[8];
	Button button_Dessert = new Button("Dessert");
	button_Dessert.setOnAction(event -> { quitButton.requestFocus(); score++; label.setText("Score: " + score); randomizeButtonPositions(new Random(), btns); });
	btns[0] = button_Dessert;
	
	for (int i=1; i<8; i++){
	    Button btn = new Button("Desert");
	    btn.setOnAction(event -> { quitButton.requestFocus(); score--; label.setText("Score: " + score); randomizeButtonPositions(new Random(), btns); });
	    btns[i] = btn;
	}			  
	randomizeButtonPositions(new Random(), btns);

	Pane pane = new Pane();
	for (Button btn_iterator : btns){
	    pane.getChildren().add(btn_iterator);
	}
	
        // update this method definition to complete this activity
	HBox hbox = new HBox(quitButton);
	hbox.setAlignment(Pos.BOTTOM_RIGHT);
        BorderPane borderPane = new BorderPane();
	borderPane.setTop(label);		
	borderPane.setBottom(hbox);
	borderPane.setCenter(pane);
	
        Scene scene = new Scene(borderPane,800,600);
        stage.setScene(scene);
	stage.setTitle("Dessert in the Desert JavaFX Game");
        stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch();
    }
}
