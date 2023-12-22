<<<<<<< HEAD
package edu.ou.cs2334.project5.handlers;

import edu.ou.cs2334.project5.models.NonogramMakerModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
/**
 * The ToggleButtonEventHandler class is responsible for handling events triggered by ToggleButtons in the Nonogram Maker application.
 * It implements the EventHandler interface for ActionEvents.
 * 
 * @author iampo
 *
 */
public class ToggleButtonEventHandler implements EventHandler<ActionEvent> {
	private NonogramMakerModel model;
	private int rowIDX;
	private int colIDX;
	 /**
     * Constructs a ToggleButtonEventHandler with the specified NonogramMakerModel, row index, and column index.
     *
     * @param m The NonogramMakerModel associated with the handler.
     * @param r The row index of the ToggleButton in the Nonogram grid.
     * @param c The column index of the ToggleButton in the Nonogram grid.
     */
	public ToggleButtonEventHandler(NonogramMakerModel m, int r, int c) {
		rowIDX = r;
		colIDX = c;
		model = m;
	}
	 /**
     * Handles the ActionEvent triggered by the ToggleButton.
     *
     * @param event The ActionEvent representing the ToggleButton event.
     */
	@Override
	public void handle(ActionEvent event) {
		//validate if event source is ToggleButton
		if(event.getSource() instanceof ToggleButton) {
			//treat event.getSource() as a ToggleButton || downcasting
			ToggleButton button = (ToggleButton) event.getSource();
			//check if button is selected
			boolean selected = button.isSelected();
			//set cell in grid to selected state
			model.setCell(rowIDX, colIDX, selected);
		}
	}

}
=======
package edu.ou.cs2334.project5.handlers;

import edu.ou.cs2334.project5.models.NonogramMakerModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
/**
 * The ToggleButtonEventHandler class is responsible for handling events triggered by ToggleButtons in the Nonogram Maker application.
 * It implements the EventHandler interface for ActionEvents.
 * 
 * @author iampo
 *
 */
public class ToggleButtonEventHandler implements EventHandler<ActionEvent> {
	private NonogramMakerModel model;
	private int rowIDX;
	private int colIDX;
	 /**
     * Constructs a ToggleButtonEventHandler with the specified NonogramMakerModel, row index, and column index.
     *
     * @param m The NonogramMakerModel associated with the handler.
     * @param r The row index of the ToggleButton in the Nonogram grid.
     * @param c The column index of the ToggleButton in the Nonogram grid.
     */
	public ToggleButtonEventHandler(NonogramMakerModel m, int r, int c) {
		rowIDX = r;
		colIDX = c;
		model = m;
	}
	 /**
     * Handles the ActionEvent triggered by the ToggleButton.
     *
     * @param event The ActionEvent representing the ToggleButton event.
     */
	@Override
	public void handle(ActionEvent event) {
		//validate if event source is ToggleButton
		if(event.getSource() instanceof ToggleButton) {
			//treat event.getSource() as a ToggleButton || downcasting
			ToggleButton button = (ToggleButton) event.getSource();
			//check if button is selected
			boolean selected = button.isSelected();
			//set cell in grid to selected state
			model.setCell(rowIDX, colIDX, selected);
		}
	}

}
>>>>>>> a4811732d4169063ca09da86600706e23557aabb
