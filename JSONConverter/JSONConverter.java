/*
 * Authored by Belton Zhong
 * 3/22/2015
 */
import java.io.*;
import java.util.*;

public class JSONConverter {
  public static void main(String[] args) {
    String filename = args[0];
    String output = args[1];
    int numLines = Integer.parseInt(args[2]);

    Scanner input = null;
    PrintWriter writer = null;
    
    try {
      input = new Scanner(new File(filename));
      writer = new PrintWriter(output, "UTF-8");
    } catch(Exception e) {
      e.printStackTrace();
    }

    String names[] = new String[numLines];
    String pops[] = new String[numLines];
    String logPops[] = new String[numLines];
    String ranks[] = new String[numLines];
    String logRanks[] = new String[numLines];
    String trendLine[] = new String[2];

    int ctr = 0;
    while(ctr < numLines) {
      String line = input.nextLine();
      String[] data = line.split("\t");
      names[ctr] = data[0];
      pops[ctr] = data[1];
      logPops[ctr] = data[2];
      ranks[ctr] = data[3];
      logRanks[ctr] = data[4];
      ctr++;
    }
    String line[] = input.nextLine().split("\t");
    trendLine[0] = line[0];
    trendLine[1] = line[1];    

    writer.println("{");

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

    writer.println("\t\"trendLine\": [");
    for(int i = 0; i < 1; i++)
      writer.println("\t\t\"" + trendLine[i] + "\",");
    writer.println("\t\t\"" + trendLine[1] + "\"");
    writer.println("\t]");
    
    writer.println("}");

    writer.close();
  }
}
