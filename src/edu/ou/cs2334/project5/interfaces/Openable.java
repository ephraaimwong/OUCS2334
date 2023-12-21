package edu.ou.cs2334.project5.interfaces;

import java.io.File;
/**
 * The Openable interface defines a contract for classes that can open files.
 * Classes implementing this interface should provide an implementation for opening a file.
 * 
 * @author iampo
 *
 */
public interface Openable {
    /**
     * Opens the specified file.
     *
     * @param file The file to be opened.
     */
	//implemented in NonogramMakerPresenter
	void open(File file);
}
