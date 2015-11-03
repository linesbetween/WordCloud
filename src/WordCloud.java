/*CIT-285 Adv.Java
 * Hanfei XU*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class WordCloud extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) throws FileNotFoundException {
	  
	  CountOccurenceOfWords countWords = new CountOccurenceOfWords("words.txt");
	  Map<String, Integer> map = countWords.count();
	  
	  //Calculate row and column numbers for grid pane
	  //If map size is unknown, (row-1)*(col-1)<mapsize<row*col
	  int mapSize = map.size();
	  int row = (int)Math.ceil(Math.sqrt(mapSize));
	  int col = row;
	 
	  
    // Create a pane and set its properties
	GridPane pane = new GridPane();
	pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(10, 10, 10, 10)); // TODO length
    pane.setHgap(2);
    pane.setVgap(2);
	
    //Put entries into grid pane
    int i=0;
    Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
    for (Map.Entry<String, Integer> entry: entrySet){
    	Label label = new Label(entry.getKey());
    	label.setTextAlignment(TextAlignment.CENTER);//does nothing...
    	label.setFont(Font.font("Times New Roman",
    	FontWeight.BOLD, FontPosture.ITALIC, (entry.getValue()*2)));
    	pane.add(label, i%row, i/col);
    	i++;
    }
	
    //label.setFont(Font.font("Times New Roman", 
      //FontWeight.BOLD, FontPosture.ITALIC, 20));
    
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 800, 600);
    primaryStage.setTitle("Word Cloud"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
  public static void main(String[] args) {
	    launch(args);
	  }
  
}
  
  
  