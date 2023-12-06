package edu.ou.cs2334.project5;

import java.util.List;
import java.util.Optional;

import edu.ou.cs2334.project5.models.NonogramMakerModel;
import edu.ou.cs2334.project5.presenters.NonogramMakerPresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * The Main class serves as the entry point for the Nonogram Maker application.
 * It extends the JavaFX Application class and initializes the GUI components.
 * @author iampo
 *
 */
public class Main extends Application{
	// Constants for command line argument indices
	private static final int IDX_NUM_ROWS =0;
	private static final int IDX_NUM_COLS =1;
	private static final int IDX_CELL_SIZE =2;
	/**
     * The main method where the Java application starts its execution.
     *
     * @param args The command line arguments passed to the program.
     */
	public static void main(String[] args) {
		launch(args);
	}
	 /**
     * Initializes and starts the JavaFX application.
     *
     * @param primaryStage The primary stage for the JavaFX application.
     * @throws Exception If an error occurs during initialization.
     */
	@Override
	public void start(Stage primaryStage) throws Exception {
		//getting params from cmd line/program args ${string_prompt}  
		Parameters params = getParameters();
		List<String> rawArgs = params.getRaw();
		int numRows = Integer.parseInt(rawArgs.get(IDX_NUM_ROWS));
		int numCols = Integer.parseInt(rawArgs.get(IDX_NUM_COLS));
		int cellSize = Integer.parseInt(rawArgs.get(IDX_CELL_SIZE));
		
		 // Creating a NonogramMakerPresenter with specified parameters
		NonogramMakerPresenter program = new NonogramMakerPresenter(numRows, numCols, cellSize);
		Scene scene = new Scene(program.getPane());
		scene.getStylesheets().add("style.css");
		
		// Creating a JavaFX scene and applying a stylesheet
		primaryStage.setScene(scene);
		primaryStage.setTitle("Application Title Here");
		
		// Configuring the primary stage
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		primaryStage.show();
	}


}
