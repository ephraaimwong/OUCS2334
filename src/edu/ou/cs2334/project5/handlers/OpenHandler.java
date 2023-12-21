package edu.ou.cs2334.project5.handlers;

import java.io.File;

import edu.ou.cs2334.project5.interfaces.Openable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Window;
/**
 * The OpenHandler class is responsible for handling "Open" events in the Nonogram Maker application.
 * It implements the EventHandler interface for ActionEvents and extends the AbstractBaseHandler class.
 * 
 * @author iampo
 *
 */
public class OpenHandler extends AbstractBaseHandler implements EventHandler<ActionEvent>{
	private Openable open;
	 /**
     * Constructs an OpenHandler with the specified window, file chooser, and Openable implementation.
     *
     * @param w The window associated with the handler.
     * @param choose The file chooser used by the handler.
     * @param open The Openable implementation for opening files.
     */
	public OpenHandler(Window w, FileChooser choose, Openable open) {
		super(w, choose);
		this.open = open;
	}
	 /**
     * Handles the "Open" event triggered by the user.
     *
     * @param event The ActionEvent representing the "Open" event.
     */
	@Override
	public void handle(ActionEvent event) {
		//Show open dialog
		File file = fileChooser.showOpenDialog(window);
		//if file is selected, call .open from Openable
		if (file != null) {
			open.open(file);
		}
		
	}
}
