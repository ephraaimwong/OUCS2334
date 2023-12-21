package edu.ou.cs2334.project5.interfaces;

import java.io.File;
/**
 * The Saveable interface defines a contract for classes that can save files.
 * Classes implementing this interface should provide an implementation for saving a file.
 * 
 * @author iampo
 *
 */
public interface Saveable {
	/**
	 * Saves the specified file
	 * 
	 * @param file File to be saved.
	 */
	//implemented in NonogramMakerPresenter
	void save(File file);
}