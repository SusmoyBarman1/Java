package application;
	
import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
	      //creating a text field 
	      TextField textField = new TextField();       
	      
	      //Creating the play button 
	      Button playButton = new Button("Play");
		   
	      //Creating the stop button 
	      Button stopButton = new Button("stop"); 
	      
	      //Instantiating the VBox class  
	      VBox vBox = new VBox();   
	      
	      //Setting the space between the nodes of a VBox pane 
	      vBox.setSpacing(10);   
	      
	      //Setting the margin to the nodes 
	      vBox.setMargin(textField, new Insets(20, 20, 20, 20));  
	      vBox.setMargin(playButton, new Insets(20, 20, 20, 20)); 
	      vBox.setMargin(stopButton, new Insets(20, 20, 20, 20));  
	      
	      //retrieving the observable list of the VBox 
	      ObservableList list = vBox.getChildren(); 
	      
	      //Adding all the nodes to the observable list 
	      list.addAll(textField, playButton, stopButton);       
	      
	      //Creating a scene object 
	      Scene scene = new Scene(vBox);  
	      
	      //Setting title to the Stage 
	      stage.setTitle("Vbox Example"); 
	         
	      //Adding scene to the stage 
	      stage.setScene(scene); 
	         
	      //Displaying the contents of the stage 
	      stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
