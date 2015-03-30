/*
 * Authored by Belton Zhong
 * 3/22/2015
 */
import java.io.*;
import java.util.*;

public class JSONConverter {
  public static void main(String[] args) {
    String filename = args[0];
    int numLines = Integer.parseInt(args[1]);
    int numTrendLines= Integer.parseInt(args[2]);

    Scanner input = null;
    PrintWriter writer = null;
    
    try {
      input = new Scanner(new File("../data/raw/" + filename + ".tsv"));
      writer = new PrintWriter("../data/" + filename + ".json", "UTF-8");
    } catch(Exception e) {
      e.printStackTrace();
    }
    
    String legend[] = new String[numTrendLines];
    String names[] = new String[numLines];
    String pops[] = new String[numLines];
    String logPops[] = new String[numLines];
    String ranks[] = new String[numLines];
    String logRanks[] = new String[numLines];
    String datasets[] = new String[numLines];
    String trendLine[] = new String[2 * numTrendLines];

    for(int num = 0; num < numTrendLines; num++) {
      String line = input.nextLine();
      legend[num] = line;
    }
    int ctr = 0;
    while(ctr < numLines) {
      String line = input.nextLine();
      String[] data = line.split("\t");
      names[ctr] = data[0];
      pops[ctr] = data[1];
      logPops[ctr] = data[2];
      ranks[ctr] = data[3];
      logRanks[ctr] = data[4];
      datasets[ctr] = data[5];
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
    for(int i = 0; i < numLines - 1; i++)
      writer.println("\t\t\"" + names[i] + "\",");
    writer.println("\t\t\"" + names[numLines - 1] + "\"");
    writer.println("\t],");
    writer.println();

    writer.println("\t\"pops\": [");
    for(int i = 0; i < numLines - 1; i++)
      writer.println("\t\t\"" + pops[i] + "\",");
    writer.println("\t\t\"" + pops[numLines - 1] + "\"");
    writer.println("\t],");
    writer.println();
    
    writer.println("\t\"logPops\": [");
    for(int i = 0; i < numLines - 1; i++)
      writer.println("\t\t\"" + logPops[i] + "\",");
    writer.println("\t\t\"" + logPops[numLines - 1] + "\"");
    writer.println("\t],");
    writer.println();

    writer.println("\t\"ranks\": [");
    for(int i = 0; i < numLines - 1; i++)
      writer.println("\t\t\"" + ranks[i] + "\",");
    writer.println("\t\t\"" + ranks[numLines - 1] + "\"");
    writer.println("\t],");
    writer.println();

    writer.println("\t\"logRanks\": [");
    for(int i = 0; i < numLines - 1; i++)
      writer.println("\t\t\"" + logRanks[i] + "\",");
    writer.println("\t\t\"" + logRanks[numLines - 1] + "\"");
    writer.println("\t],");
    writer.println();

    writer.println("\t\"datasets\": [");
    for(int i = 0; i < numLines - 1; i++)
      writer.println("\t\t\"" + datasets[i] + "\",");
    writer.println("\t\t\"" + datasets[numLines - 1] + "\"");
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
