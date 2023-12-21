package edu.ou.cs2334.project5.handlers;

import javafx.stage.FileChooser;
import javafx.stage.Window;
/**
 * The AbstractBaseHandler class serves as the base class for all event handlers in the Nonogram Maker application.
 * It provides common properties and methods that are shared among different handler implementations.
 * @author iampo
 *
 */
public abstract class AbstractBaseHandler {
	// The window associated with the handler.
	protected Window window;
	protected FileChooser fileChooser;
	 
	/**
     * Constructs an AbstractBaseHandler with the specified window and file chooser.
     *
     * @param w The window associated with the handler.
     * @param f The file chooser used by the handler.
     */
	protected AbstractBaseHandler(Window w, FileChooser f) {
		window = w;
		fileChooser = f;
	}

}
