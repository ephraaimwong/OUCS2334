package edu.ou.cs2334.project5.views;

import java.util.HashMap;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
/**
 * The CellGridView class represents the grid view of cells in the Nonogram Maker application.
 * It provides methods to initialize and manage a grid of ToggleButtons.
 *
 * @author iampo
 *
 */
public class NonogramMakerView {
	/** The main BorderPane layout for organizing the components. */
	private BorderPane borderPane;
	/** The MenuBar for containing menu items. */
	private MenuBar menuBar;
	private CellGridView cellGridView;
	private HashMap<String, MenuItem> menuItemsMap;
	/** Constant representing the "Open" menu item. */
	public static String MENU_ITEM_OPEN = "MENU_ITEM_OPEN";
	/** Constant representing the "Save" menu item. */
	public static String MENU_ITEM_SAVE = "MENU_ITEM_SAVE";
	/** Constant representing the "Exit" menu item. */
	public static String MENU_ITEM_EXIT = "MENU_ITEM_EXIT";
	/**
     * Constructs a NonogramMakerView with the specified number of rows, columns, and cell length.
     *
     * @param numRows The number of rows in the Nonogram grid.
     * @param numCols The number of columns in the Nonogram grid.
     * @param cellLength The length of each cell in the grid.
     */
	public NonogramMakerView(int numRows, int numCols, int cellLength) {
		//initialize BorderPane, CellGridView, initMenuBar, menuItemsMap
		menuItemsMap = new HashMap<>();
		borderPane = new BorderPane();
		cellGridView = new CellGridView(numRows, numCols, cellLength);
		initMenuBar();
		//Set top and center elements
		borderPane.setTop(menuBar);
		borderPane.setCenter(cellGridView.getPane());
	}
	/**
     * Initializes the MenuBar with file-related menu items.
     */
	private void initMenuBar() {
		//initialize menu bar
		menuBar = new MenuBar();
		//create file menu
		Menu fileMenu = new Menu("_File");
		//create menu items
		MenuItem open = new MenuItem("_Open");
		MenuItem save = new MenuItem("_Save");
		MenuItem exit = new MenuItem("_Exit");
		
		//add menuitems to menuitemsMap
		fileMenu.getItems().addAll(open,save,exit);
		menuItemsMap.put(MENU_ITEM_OPEN, open);
		menuItemsMap.put(MENU_ITEM_SAVE, save);
		menuItemsMap.put(MENU_ITEM_EXIT, exit);
		
		//add ActionEvent EventHandler to exit
		exit.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		
		//add file menu to menuBar
		menuBar.getMenus().add(fileMenu);
		
		//assign completed menubar to top of borderPane
		borderPane.setTop(menuBar);
	}
	/**
     * Retrieves the MenuItem with the specified name from the menuItemsMap.
     *
     * @param s The name of the menu item.
     * @return The MenuItem with the specified name, or null if not found.
     */
	public MenuItem getMenuItem(String s) {
		return menuItemsMap.get(s);
	}
	/**
     * Retrieves the main pane of the NonogramMakerView.
     *
     * @return The main pane of the NonogramMakerView.
     */
	public Pane getPane() {
		return borderPane;
	}
	/**
     * Initializes the ToggleButtons in the cell grid with the specified number of rows, columns, and cell length.
     *
     * @param numRows The number of rows in the Nonogram grid.
     * @param numCols The number of columns in the Nonogram grid.
     * @param cellLength The length of each cell in the grid.
     */
	public void initButtons(int numRows, int numCols, int cellLength) {
		cellGridView.initButtons(numRows, numCols, cellLength);
	}
	/**
     * Retrieves the ToggleButton at the specified row and column in the cell grid.
     *
     * @param r The row index of the ToggleButton.
     * @param c The column index of the ToggleButton.
     * @return The ToggleButton at the specified row and column, or null if out of bounds.
     */
	public ToggleButton getToggleButton(int r, int c) {
		return cellGridView.getToggleButton(r,c);
	}
	/**
     * Retrieves the number of rows in the cell grid.
     *
     * @return The number of rows in the cell grid.
     */
	public int getNumRows() {
		return cellGridView.getNumRows();	
	}
	/**
     * Retrieves the number of columns in the cell grid.
     *
     * @return The number of columns in the cell grid.
     */
	public int getNumCols() {
		return cellGridView.getNumCols();
	}

}
