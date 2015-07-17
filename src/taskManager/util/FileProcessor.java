package taskManager.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor{
    private String fileName;
 
 	/** 
	 * FileProcessor constructor
	 * @param fileNameIn name of file to process
 	*/   
    public FileProcessor(String fileNameIn){
	fileName = fileNameIn;
    }
    
    /**
	 * returns the given line from the file as a string
	 * @param lineNum line num to read from file
	 * @return string holding that line from file
    */
    public String readALine(int lineNum){
	String returnLine = "DONE";
	try(BufferedReader in = new BufferedReader(new FileReader(fileName))){
	    String line;
	    int currentLineNum = 0;
	    while((line = in.readLine()) != null){
		if(currentLineNum == lineNum){    
		    returnLine = line;
		}
		currentLineNum++;
	    }
	}catch(IOException e){
	    System.err.println("Error in FileProcessor creating reader");
	    System.err.println(e.getMessage());
	}
	return returnLine;
    }

    /**
	 * writes a given line to a file
	 * @param line to write to file
    */
    public void writeALine(String line){
	try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
	    out.println(line);
	}catch (IOException e) {
	    System.err.println("Error printing to file");
	    System.err.println(e.getMessage());
	    System.exit(1);
	}
    }
    
}
