package edu.ou.cs2334.project5.handlers;

import java.io.File;

import edu.ou.cs2334.project5.interfaces.Saveable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Window;
/**
 * The SaveHandler class is responsible for handling "Save" events in the Nonogram Maker application.
 * It implements the EventHandler interface for ActionEvents and extends the AbstractBaseHandler class.
 * 
 * @author iampo
 *
 */
public class SaveHandler extends AbstractBaseHandler implements EventHandler<ActionEvent>{
	private Saveable saver;
	/**
	 * The SaveHandler takes a Window, FileChooser, and a Saveable as parameters to facilitate the saving of data to a file.
	 * 
	 * @param w Window
	 * @param chooser FileChooser
	 * @param s Saveable Object
	 */
	public SaveHandler(Window w, FileChooser chooser, Saveable s) {
		super(w,chooser);
		saver = s;
	}
	/**
     * Constructs a SaveHandler with the specified window, file chooser, and Saveable implementation.
     *
     * @param event ActionEvent
     */
	@Override
	public void handle(ActionEvent event) {
		//show open dialog
		File file = fileChooser.showSaveDialog(window);
		//if file is selected, call .save method from saveable
		if(file!=null) {
			saver.save(file);
		}
	}
}
