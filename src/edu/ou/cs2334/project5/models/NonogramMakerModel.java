package edu.ou.cs2334.project5.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * 
 * @author iampo
 * NonogramMakerModel class using 1D boolean[] array as logic for puzzle projection and 
 *
 */
public class NonogramMakerModel {
	private static final char EMPTY_CELL_CHAR = '0';
	private static final char FILLED_CELL_CHAR = '1';
	private int numRows,numCols;
	private boolean[] grid;
	/**
	 * default constructor, creates a 1D array of grid cells, all false by default
	 * @param row row
	 * @param col column
	 * 
	 */
	public NonogramMakerModel(int row, int col) {
		if (row<=0||col<=0) {
			throw new IllegalArgumentException();
		}
		numRows=row;
		numCols=col;
		grid = new boolean[row*col];
	}
	/**
	 * reads file with specified format
	 * reads first line for dimensions of grid
	 * skips projection for row and columns
	 * reads grid, changing grid cell to true if "1" since all is false by default
	 * @param file filepath
	 * @throws IOException file does not follow specified format
	 * 
	 */
	public NonogramMakerModel(File file) throws IOException{
		try(BufferedReader read = new BufferedReader(new FileReader(file))){
			//use first line to determine num of columns
			String line = read.readLine();
			String[] val = line.split(" ");
			numCols = Integer.parseInt(val[1]);
			numRows = Integer.parseInt(val[0]);
			grid = new boolean[numRows*numCols];
			//skipping projection numbers
			for(int i=0;i<numRows+numCols;i++) {
				if(line!=null) {
					line=read.readLine();
				}
			}
			for(int rowIDX=0;rowIDX<numRows;rowIDX++) {
				//read row
				line=read.readLine();
				for(int colIDX=0; colIDX<numCols;colIDX++) {
					//evaluating element in row
					if(line.charAt(colIDX)!= EMPTY_CELL_CHAR){setCell(rowIDX, colIDX, true);}
				}
			}
			read.close();
		}
	}
	/**
	 * reads file, calls NonogramMakerModel(File file) constructor
	 * @param filename filepath
	 * @throws IOException invalid filepath
	 * 
	 */
	public NonogramMakerModel(String filename) throws IOException{
		//calls the above constructor
		this(new File(filename));
	}
	/**
	 * copy of grid
	 * @return copy of boolean[] grid
	 */
	public boolean[] getGrid() {
		return Arrays.copyOf(grid, grid.length);
	}
	/**
	 * get cell value
	 * @param r row
	 * @param c column
	 * @return boolean value of grid cell
	 */
	public boolean getCell(int r, int c) {
		if(r<0||r>=numRows||c<0||c>=numCols) {
			throw new IllegalArgumentException();
		}
		//since 1D array, every row = max number of col
		return grid[r*numCols+c];
	}
	/**
	 * change cell value
	 * @param r row
	 * @param c column
	 * @param state set boolean value of grid cell
	 */
	public void setCell(int r, int c, boolean state) {
		if(r<0||r>=numRows||c<0||c>=numCols) {
			throw new IllegalArgumentException();
		}
		grid[r*numCols+c]=state;
	}
	/**
	 * get number of rows
	 * @return numRows
	 */
	public int getNumRows() {return numRows;}
	/**
	 * get number of columns
	 * @return numCols
	 */
	public int getNumCols() {return numCols;}
	/**
	 * projecting nonogram numbers 
	 * @param cells boolean[] grid
	 * @return projection of how many true values, numbers>1 means consecutive true values
	 * 0 is returned if no true is found
	 * i.e [1,1,4,1]
	 */
	public static List<Integer> project(boolean[] cells){
		List<Integer> project = new ArrayList<>();
		int count = 0;
		//hot fix to add 0 list if no projection found
		boolean t = false;
		for (boolean i:cells) {
			if(i) {
				count++;
				t = true;
			}
			//cell empty but there was prior filled group
			else if(count>0) {
				project.add(count);
				//reset count for next group
				count=0;
			}
		}
		//adding last group(if any)
		if(count>0) {
			project.add(count);
		}
		if(!t) {
			project.add(0);
		}
		return project;
	}
	/**
	 * projecting nonogram numbers in row
	 * @param r row
	 * @return projected true values in each row, returns 0 if none found
	 * i.e. [1,1,4,1]
	 */
	public List<Integer> projectRow(int r){
		//new code to account for when numRows,r = 0;
		if(r<0||r>=numRows) {throw new IllegalArgumentException();}
		//copying row cell values
		boolean[] tempRow = Arrays.copyOfRange(grid, r*numCols, (r+1)*numCols);
		return project(tempRow);
	}
	/**
	 * projecting nonogram numbers in column
	 * @param c column
	 * @return projected true values in each column, returns 0 if none found
	 * i.e. [1,1,4,1]
	 */
	public List<Integer> projectCol(int c){
		if(c<0||c>=numCols) {throw new IllegalArgumentException();}
		boolean[] tempCol = new boolean[numRows];
		for (int i=0; i<numRows;i++) {
			tempCol[i] = grid[i * numCols + c];
		}
		return project(tempCol);

	}
	/**
	 * save file
	 * @param filename filepath
	 * @throws IOException invalid filepath
	 */
	public void saveToFile(String filename) throws IOException {
		try(BufferedWriter write = new BufferedWriter(new FileWriter(filename))){
			write.write(toString());

		}
	}
	/**
	 * returns String representation of dimensions, projected rows, projected columns, and the puzzle grid
	 * i.e. 
	 * 3 3
	 * 0
	 * 0
	 * 1
	 * 0
	 * 0
	 * 1
	 * 000
	 * 000
	 * 001
	 */
	@Override
	public String toString() {
		List<String> lines = new ArrayList<>();
		//dimensions of puzzle
		lines.add(numRows + " " + numCols);

		//project rows
		for(int i=0;i<numRows;i++) {
			List<Integer> rowPP = projectRow(i);
			//stream() turns rowPP into a stream which allows mapping functions
			//map(object::toSting) returns string representation of each element
			//toArray(String[]::new) creates new String array containing string elements from above
			String lineAsOne = String.join(" ", rowPP.stream().map(Object::toString).toArray(String[]::new));
			lines.add(lineAsOne);
		}
		//project col
		for(int i=0;i<numCols;i++) {
			List<Integer> colPP = projectCol(i);
			String lineAsOne = String.join(" ", colPP.stream().map(Object::toString).toArray(String[]::new));
			lines.add(lineAsOne);
		}
		//Full grid
		for(int i=0;i<numRows;i++) {
			StringBuilder row = new StringBuilder();
			for(int j=0;j<numCols;j++) {
				//? == if else, appends FILLED_CELL_CHAR if true, else append EMPTY_CELL_CHAR
				row.append(getCell(i,j) ? FILLED_CELL_CHAR:EMPTY_CELL_CHAR);
			}
			// whole row is added as a single string
			lines.add(row.toString());
		}
		String result = String.join(System.lineSeparator(), lines);

		return result;
	}

}
