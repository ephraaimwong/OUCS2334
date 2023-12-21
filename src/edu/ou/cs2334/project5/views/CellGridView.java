package edu.ou.cs2334.project5.views;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
/**
 * The NonogramMakerView class represents the graphical user interface of the Nonogram Maker application.
 * It includes methods to initialize the main components such as the menu bar and cell grid view.
 *
 * @author iampo
 *
 */
public class CellGridView {
	private ArrayList<ToggleButton> gridButtons;
	/** The GridPane layout for organizing the ToggleButtons. */
	private GridPane gridPane;
	private int numRows,numCols;
	
	/**
     * Constructs a CellGridView with the specified number of rows, columns, and cell length.
     *
     * @param numRows The number of rows in the grid.
     * @param numCols The number of columns in the grid.
     * @param cellLength The length of each cell in the grid.
     */
	public CellGridView(int numRows,int numCols,int cellLength) {
		this.numRows = numRows;
		this.numCols = numCols;
		gridButtons = new ArrayList<>();
		gridPane = new GridPane();
		//alignment CENTER
		BorderPane.setAlignment(gridPane, Pos.CENTER);
		initButtons(numRows, numCols,cellLength);
	}
	/**
     * Initializes the ToggleButtons in the grid with the specified number of rows, columns, and cell length.
     *
     * @param numRows The number of rows in the grid.
     * @param numCols The number of columns in the grid.
     * @param cellLength The length of each cell in the grid.
     */
	public void initButtons(int numRows,int numCols,int cellLength) {
		this.numRows = numRows;
		this.numCols = numCols;
		gridPane.getChildren().clear();
		gridButtons.clear();
		
		for(int row=0;row<numRows;row++) {
			for(int col=0;col<numCols;col++) {
				ToggleButton button = new ToggleButton();
				
				button.setMinWidth(cellLength);
				button.setMaxWidth(cellLength);
				button.setPrefWidth(cellLength);
				
				button.setMinHeight(cellLength);
				button.setMaxHeight(cellLength);
				button.setPrefHeight(cellLength);
				
				gridButtons.add(button);
				gridPane.add(button, col, row);
			}
		}
	}
	/**
     * Retrieves the number of rows in the grid.
     *
     * @return The number of rows in the grid.
     */
	public int getNumRows() {return numRows;}
	/**
     * Retrieves the number of columns in the grid.
     *
     * @return The number of columns in the grid.
     */
	public int getNumCols() {return numCols;}
	/**
     * Retrieves the ToggleButton at the specified row and column in the grid.
     *
     * @param row The row index of the ToggleButton.
     * @param col The column index of the ToggleButton.
     * @return The ToggleButton at the specified row and column, or null if out of bounds.
     */
	public ToggleButton getToggleButton(int row,int col) {
		if (row<0 || row >= numRows || col<0 || col>=numCols) {
			return null;
		}else {return gridButtons.get(row*numCols+col);}
	}
	/**
     * Retrieves the main pane of the CellGridView.
     *
     * @return The main pane of the CellGridView.
     */
	public Pane getPane() {
		return gridPane;
	}

}
