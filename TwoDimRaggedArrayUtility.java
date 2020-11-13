import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TwoDimRaggedArrayUtility{

  public static double[][] readFile(java.io.File file){
    if (file == null)
      return null;
    int stores = 0;
    int categories = 0;
    double[][] tmp = new double[10][10];
    int[] sizes = new int[10];
    Scanner sc;
    try {
        sc = new Scanner(file);
    }
      catch(Exception e) {
        return null;
      }
    while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] tokens = line.split(" ");
        if (tokens.length <= 0)
          continue;
        sizes[stores] = tokens.length;
        if (stores == 0)
          categories = tokens.length;
        else if (tokens.length > categories)
          categories = tokens.length;
        for (int j = 0; j < tokens.length; j++)
          tmp[stores][j] = Double.valueOf(tokens[j]);
        stores++;
    }
    if (stores == 0)
      return null;
    double[][] data = new double[stores][];
    for (int i = 0; i < stores; i++) {
      data[i] = new double[sizes[i]];
      for (int j = 0; j < data[i].length; j++)
        data[i][j] = tmp[i][j];
    }
    return data;
}
  public static void writeToFile(double[][] data, java.io.File outputFile) {
    if (data == null)
      return;
    if (outputFile == null)
      return;
	  FileWriter fout;
	  try {
		  fout = new FileWriter(outputFile);
	  }
	  catch(Exception e) {
		  return;
	  }
    if (data.length <= 0)
      return;
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        if (data[i].length <= 0)
          continue;
    	  try {
        fout.write(String.valueOf(data[i][j]));
    	  }
    	  catch(Exception e){
    		  return;
    	  }
        if (j < data[i].length - 1)
        	try {
          fout.write(" ");
        	}
        catch(Exception e) {
        	return;
        }
      }
      try {
      fout.write("\n");
    }
      catch(Exception e) {
    	  return;
      }
    }
  }
  public static double getTotal(double[][] data) {
    double total = 0.0;
    for (int i = 0; i < data.length; i++)
      for (int j = 0; j < data[i].length; j++)
        total += data[i][j];
    return total;
  }
  public static double getAverage(double[][] data){
    double total = 0.0;
    int n = 0;
      for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++){
          total += data[i][j];
        }
        n += data[i].length;
      }
    double average = total/n;
    return average; 
  }
  public static double getRowTotal(double[][] data, int row){
    double rowTotal = 0;
      for (int j = 0; j < data[row].length; j++){
        rowTotal += data[row][j];
    }
    return rowTotal;
  }
  public static double getColumnTotal(double[][] data, int col){
    double columnTotal = 0;
      for (int i = 0; i < data.length; i++){
        if (col < data[i].length)
          columnTotal += data[i][col];
    }
    return columnTotal;
  }
  public static double getHighestInRow(double[][] data, int row){
    double highestValueInRow = 0;
    for (int j = 0; j < data[row].length; j++)
      if (data[row][j] > highestValueInRow)
        highestValueInRow = data[row][j];
    return highestValueInRow;
  }
  public static int getHighestInRowIndex(double[][] data, int row){
     double highestValueInRow = 0;
     int highestIndex = 0;
    for (int j = 0; j < data[row].length; j++)
      if (data[row][j] > highestValueInRow) {
        highestValueInRow = data[row][j];
        highestIndex = j;
      }
    return highestIndex;
  }
  public static double getLowestInRow(double[][] data, int row){
    double lowestValueInRow = Double.MAX_VALUE;
    for (int j = 0; j < data[row].length; j++)
      if (data[row][j] < lowestValueInRow)
        lowestValueInRow = data[row][j];
      return lowestValueInRow;
  }
  public static int getLowestInRowIndex(double[][] data, int row){
    double lowestValueInRow = Double.MAX_VALUE;
    int lowestIndex = 0;
    for (int j = 0; j < data[row].length; j++)
      if (data[row][j] < lowestValueInRow){
        lowestValueInRow = data[row][j];
        lowestIndex = j;
      }
      return lowestIndex;
  }
  public static double getHighestInColumn(double[][] data, int col){
    double highestValueInColumn = 0;
    for (int i = 0; i < data.length; i++)
      if (col < data[i].length)
        if (data[i][col] > highestValueInColumn)
          highestValueInColumn = data[i][col];
      return highestValueInColumn;
  }
  public static int getHighestInColumnIndex(double[][] data, int col){
    double highestValueInColumn = 0;
    int highestIndex = 0;
    for (int i = 0; i < data.length; i++)
      if (col < data[i].length)
        if (data[i][col] > highestValueInColumn){
          highestValueInColumn = data[i][col];
          highestIndex = i;
        }
      return highestIndex;
  }
  public static double getLowestInColumn(double[][] data, int col){
    double lowestValueInColumn = Double.MAX_VALUE;
    for (int i = 0; i < data.length; i++)
      if (col < data[i].length)
        if (data[i][col] < lowestValueInColumn)
          lowestValueInColumn = data[i][col];
    return lowestValueInColumn;
  }
  public static int getLowestInColumnIndex(double[][] data, int col){
    double lowestValueInColumn = Double.MAX_VALUE;
    int lowestIndex = 0;
    for (int i = 0; i < data.length; i++)
      if (col < data[i].length)
        if (data[i][col] < lowestValueInColumn){
          lowestValueInColumn = data[i][col];
          lowestIndex = i;
        }
    return lowestIndex;
  }
  public static double getHighestInArray(double[][] data){
    double highestValueInArray = 0;
    for (int i = 0; i < data.length; i++)
      for (int j = 0; j < data[i].length; j++)
        if (data[i][j] > highestValueInArray)
        highestValueInArray = data[i][j];
        return highestValueInArray;
  }
  public static double getLowestInArray(double[][] data){
    double lowestValueInArray = Double.MAX_VALUE;
    for (int i = 0; i < data.length; i++)
      for (int j = 0; j < data[i].length; j++)
        if (data[i][j] < lowestValueInArray)
        lowestValueInArray = data[i][j];
        return lowestValueInArray;
  }
}