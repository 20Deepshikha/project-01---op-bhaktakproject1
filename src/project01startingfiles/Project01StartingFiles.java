/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project01startingfiles;

/**
 * Class: 44-241 Computer Programming II
 * Author: Krusha Bhakta
 * Description: Project 01
 * Due: 07-24-2022
 * I pledge that I have completed the programming assignment independently
 * I have not copied the code from a student or any source
 * I have not given my code to another student
 */


import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author krush
 */
public class Project01StartingFiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //Getting user to select Input File
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File myFile = fileChooser.getSelectedFile();
        Scanner inputFile = new Scanner(myFile);
    
        //Creating new Output File
        FileWriter outputFile = new FileWriter("c:\\0\\SP500output.txt");
        PrintWriter pw = new PrintWriter(outputFile);
      
        //Setting initial values for Minimum and Maximum
        String[] string = inputFile.nextLine().split(",");
        String close = string[4];
        double min = Double.parseDouble(close);
        double max = Double.parseDouble(close);
        String[] minArr = new String[6];
        String[] maxArr = new String[6];
              
        //Setting inital value for Total Volume
        String startVol = string[5];
        long totalVol = Long.parseLong(startVol);
        
        //Setting initial value for Number of Stocks
        long numStocks = 1;
        
        //Finding Minimum and Maximum
        while (inputFile.hasNext()) 
        {
            
            String[] string1 = inputFile.nextLine().split(",");
            String value = string1[4];
            //Finding Minimum
            if (Double.parseDouble(value) < min)
            {
                min = Double.parseDouble(value);
                minArr = string1;
            }
            //Finding Maximum
            if (Double.parseDouble(value) > max)
            {
                max = Double.parseDouble(value);
                maxArr = string1;
            }
            
            //Counting Total Volume
            String volume = string1[5];
            totalVol += Long.parseLong(volume);
            
            //Counting Number of Stocks
            numStocks++;   
        }
        pw.flush();
        inputFile.close();
        
        //Getting user to select Input File
        JFileChooser fileChooser2 = new JFileChooser();
        fileChooser2.showOpenDialog(null);
        File myFile2 = fileChooser2.getSelectedFile();
        Scanner inputFile2 = new Scanner(myFile2);
        
        //Initializing Stock Transactions
        long maxTrans = 0;
        long minTrans = 0;
        String maxTicker = maxArr[6];
        String minTicker = minArr[6];
        
        while (inputFile2.hasNext()) 
        {
            String[] string1 = inputFile2.nextLine().split(",");
            String value2 = string1[6];
            
            //Finding Transactions for Minimum
            if (value2.equals(minTicker))
            {
                minTrans++;
            }
            
            //Finding Transactions for Maximum
            if (value2.equals(maxTicker))
            {
                maxTrans++;
            }
        }
        pw.flush();
        inputFile2.close();
       
    
        //PRINT STATEMENTS - Calling Methods
        
        //Printing Minimum Data to Screen
        printMinToScreen(minArr, minTrans);
        
        //Printing Maximum Data to Screen
        printMaxToScreen(maxArr, maxTrans);
        
        //Printing Average Volumes to Screen
        findandPrintAverage(numStocks, totalVol);
        
        //Printing Minimum Data to File
        printMinToFile(minArr, minTrans, pw);
        
        //Printing Maximum Data to File
        printMaxToFile(maxArr, maxTrans, pw);
        
        //Printing Average Volumes to Screen
        findandPrintAverageToFile(numStocks, totalVol, pw);
        
        pw.close();
    
     }
    
    //Method to print min data to screen
    public static void printMinToScreen(String[] minParts, long count)
    {
        System.out.println("Minimum Closing Stock Information");
        System.out.println("Date: \t" + minParts[0]);
        System.out.println("Ticker: \t" + minParts[6]);
        System.out.println("Open Price: \t" + minParts[1]);
        System.out.println("High Price: \t" + minParts[2]);
        System.out.println("Low Price: \t" + minParts[3]);
        System.out.println("Closing Price: \t" + minParts[4]);
        System.out.println("Volume: \t" + minParts[5]);
        System.out.println(minParts[6] + " stock transactions: " + count + "\n");
    }
    
    //Method to print max data to screen
    public static void printMaxToScreen(String[] maxParts, long count)
    {
        System.out.println("Maximum Closing Stock Information");
        System.out.println("Date: \t" + maxParts[0]);
        System.out.println("Ticker: \t" + maxParts[6]);
        System.out.println("Open Price: \t" + maxParts[1]);
        System.out.println("High Price: \t" + maxParts[2]);
        System.out.println("Low Price: \t" + maxParts[3]);
        System.out.println("Closing Price: \t" + maxParts[4]);
        System.out.println("Volume: \t" + maxParts[5]);
        System.out.println(maxParts[6] + " stock transactions: " + count + "\n");
    }
    
    //Method to find and print average volumes
    public static void findandPrintAverage(long count, long total)
    {
        System.out.println("Number of stock: \t" + count);
        System.out.println("Stock volume total: " + total);
        System.out.println("Average volumes: \t" + (total/count));
    }
    
    //Method to print min data to file
    public static void printMinToFile(String[] minParts, long count, PrintWriter file)
    {
        file.println("Minimum Closing Stock Information");
        file.println("Date: \t" + minParts[0]);
        file.println("Ticker: \t" + minParts[6]);
        file.println("Open Price: \t" + minParts[1]);
        file.println("High Price: \t" + minParts[2]);
        file.println("Low Price: \t" + minParts[3]);
        file.println("Closing Price: \t" + minParts[4]);
        file.println("Volume: \t" + minParts[5]);
        file.println(minParts[6] + " stock transactions: " + count + "\n");
        file.flush();
    }
    
    //Method to print max data to file
    public static void printMaxToFile(String[] maxParts, long count, PrintWriter file)
    {
        file.println("Maximum Closing Stock Information");
        file.println("Date: \t" + maxParts[0]);
        file.println("Ticker: \t" + maxParts[6]);
        file.println("Open Price: \t" + maxParts[1]);
        file.println("High Price: \t" + maxParts[2]);
        file.println("Low Price: \t" + maxParts[3]);
        file.println("Closing Price: \t" + maxParts[4]);
        file.println("Volume: \t" + maxParts[5]);
        file.println(maxParts[6] + " stock transactions: " + count + "\n");
        file.flush();
    }
    
    //Method to print average data to file
    public static void findandPrintAverageToFile(long count, long total, PrintWriter file)
    {
        file.println("Number of stock: \t" + count);
        file.println("Stock volume total: \t" + total);
        file.println("Average volumes: \t" + (total/count));
        file.flush();
    }
}
