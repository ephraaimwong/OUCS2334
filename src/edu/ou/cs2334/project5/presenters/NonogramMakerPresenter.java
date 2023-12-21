package edu.ou.cs2334.project5.presenters;

import java.io.File;
import java.io.IOException;

import edu.ou.cs2334.project5.handlers.OpenHandler;
import edu.ou.cs2334.project5.handlers.SaveHandler;
import edu.ou.cs2334.project5.handlers.ToggleButtonEventHandler;
import edu.ou.cs2334.project5.interfaces.Openable;
import edu.ou.cs2334.project5.interfaces.Saveable;
import edu.ou.cs2334.project5.models.NonogramMakerModel;
import edu.ou.cs2334.project5.views.NonogramMakerView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;
/**
 * The NonogramMakerPresenter class serves as the controller for the Nonogram Maker application.
 * It handles user interactions, communicates with the model and view, and manages the application's logic.
 * 
 * @author iampo
 *
 */
public class NonogramMakerPresenter implements Openable, Saveable{
	private NonogramMakerView view;
	private NonogramMakerModel model;
	private int cellLength;
	 /**
     * Constructs a NonogramMakerPresenter with the specified number of rows, columns, and cell length.
     *
     * @param r The number of rows in the Nonogram grid.
     * @param c The number of columns in the Nonogram grid.
     * @param length The length of each cell in the grid.
     */
	public NonogramMakerPresenter(int r, int c, int length) {
		cellLength = length;
		model = new NonogramMakerModel(r,c);
		view = new NonogramMakerView(r,c,length);
		init();
	}
	/**
     * Initializes the presenter by setting up the toggle buttons, binding their events, and configuring menu items.
     */
	private void init() {
		initToggleButtons();
		bindToggleButtons();
		configureMenuItems();
	}
	
	 /**
     * Initializes the toggle buttons in the view.
     */
	private void initToggleButtons() {
		//calling view's initButtons method
		view.initButtons(model.getNumRows(),model.getNumCols(), cellLength);
	}
	/**
     * Binds toggle buttons' states and adds ToggleButtonEventHandlers to each button.
     */
	private void bindToggleButtons() {
		//Check view's toggle button state matches model's state
		//add togglebuttoneventhandler to each button
		for(int row=0;row<model.getNumRows();row++) {
			for(int col=0;col<model.getNumCols();col++) {
				ToggleButton button = view.getToggleButton(row, col);
				button.setSelected(model.getCell(row,col));
				button.setOnAction(new ToggleButtonEventHandler(model,row,col));
			}
		}
	}
	/**
     * Configures menu items for opening and saving files.
     */
	private void configureMenuItems() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		fileChooser.setInitialDirectory(new File("."));
		MenuItem open = view.getMenuItem(NonogramMakerView.MENU_ITEM_OPEN);
		open.setOnAction(new OpenHandler(getWindow(), fileChooser, (Openable)this));
		
		fileChooser.setTitle("Save");
		MenuItem save = view.getMenuItem(NonogramMakerView.MENU_ITEM_SAVE);
		save.setOnAction(new SaveHandler(getWindow(), fileChooser, (Saveable)this));
		
	}
	/**
     * Retrieves the window associated with the presenter's view.
     *
     * @return The window associated with the presenter's view, or null if not available.
     */
	private Window getWindow() {
		try {
			//view's pane's scene's window
			return view.getPane().getScene().getWindow();
		} catch (NullPointerException e) {
			return null;
		}
	}
	/**
     * Retrieves the main pane of the presenter's view.
     *
     * @return The main pane of the presenter's view.
     */
	public Pane getPane() {
		return view.getPane();
	}
	/**
     * Opens the specified file using the NonogramMakerModel.
     *
     * @param file The file to be opened.
     */
	@Override
	public void open(File file) {
		try {
			NonogramMakerModel newModel = new NonogramMakerModel(file);
			model = newModel;
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 /**
     * Saves the NonogramMakerModel data to the specified file.
     *
     * @param file The file to which the data should be saved.
     */
	@Override
	public void save(File file) {
		try {
			model.saveToFile(file.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Error: File not found");
			e.printStackTrace();
		}
	}
}
