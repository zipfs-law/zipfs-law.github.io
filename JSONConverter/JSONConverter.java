/*
 * Authored by Belton Zhong
 * 3/22/2015
 */
import java.io.*;
import java.util.*;

public class JSONConverter {
  public static void main(String[] args) {
    String filename = args[0];
    int numLinesInFile = Integer.parseInt(args[1]);
    int numTrendLines = 1;

    Scanner input = null;
    PrintWriter writer = null;
    
    try {
      input = new Scanner(new File("../data/raw/" + filename + ".tsv"));
      writer = new PrintWriter("../data/" + filename + ".json", "UTF-8");
    } catch(Exception e) {
      e.printStackTrace();
      System.exit(0);
    }
    
    String legend[] = new String[numTrendLines];
    String names[] = new String[numLinesInFile];
    String logPops[] = new String[numLinesInFile];
    String logRanks[] = new String[numLinesInFile];
    String trendLine[] = new String[2 * numTrendLines];

    for(int num = 0; num < numTrendLines; num++) {
      String line = input.nextLine();
      legend[num] = line.trim();;
    }

    int ctr = 0;
    while(ctr < numLinesInFile) {
      String line = input.nextLine();
      String[] data = line.split("\t");
      names[ctr] = data[0];
      logRanks[ctr] = data[1];
      logPops[ctr] = data[2];
      ctr++;
    }

    for(int i = 0; i < numTrendLines; i++) {
      String line[] = input.nextLine().split("\t");
      trendLine[2 * i] = line[0];
      trendLine[2 * i + 1] = line[1];    
    }

    writer.println("{");

    writer.println("\t\"legendNames\": [");
    for(int i = 0; i < numTrendLines - 1; i++)
      writer.println("\t\t\"" + legend[i] + "\",");
    writer.println("\t\t\"" + legend[numTrendLines - 1] + "\"");
    writer.println("\t],");
    writer.println();

    writer.println("\t\"names\": [");
    for(int i = 0; i < numLinesInFile - 1; i++)
      writer.println("\t\t\"" + names[i] + "\",");
    writer.println("\t\t\"" + names[numLinesInFile - 1] + "\"");
    writer.println("\t],");
    writer.println();
    
    writer.println("\t\"logRanks\": [");
    for(int i = 0; i < numLinesInFile - 1; i++)
      writer.println("\t\t\"" + logRanks[i] + "\",");
    writer.println("\t\t\"" + logRanks[numLinesInFile - 1] + "\"");
    writer.println("\t],");
    writer.println();

    writer.println("\t\"logPops\": [");
    for(int i = 0; i < numLinesInFile - 1; i++)
      writer.println("\t\t\"" + logPops[i] + "\",");
    writer.println("\t\t\"" + logPops[numLinesInFile - 1] + "\"");
    writer.println("\t],");
    writer.println();

    writer.println("\t\"trendLines\": [");
    for(int i = 0; i < numTrendLines - 1; i++) {
      writer.println("\t\t\"" + trendLine[2 * i] + "\",");
      writer.println("\t\t\"" + trendLine[2 * i + 1] + "\",");
    }
    writer.println("\t\t\"" + trendLine[2 * (numTrendLines - 1)] + "\",");
    writer.println("\t\t\"" + trendLine[2 * (numTrendLines - 1) + 1] + "\"");
    writer.println("\t]");
    
    writer.println("}");

    writer.close();
  }
}
