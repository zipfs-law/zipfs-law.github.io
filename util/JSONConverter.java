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
    
    int ctr = 0;
    while(input.hasNext()) {
      String line = input.nextLine();
      String[] data = line.split("\t");
      names[ctr] = data[0];
      pops[ctr] = data[1];
      logPops[ctr] = data[2];
      ranks[ctr] = data[3];
      logRanks[ctr] = data[4];
      ctr++;
    }
    
    writer.println("{");

    writer.println("\t\"names\": [");
    for(int i = 0; i < numLines - 1; i++)
      writer.println("\t\t\"" + names[i] + "\",");
    writer.println("\t\t\"" + names[numLines - 1] + "\"");
    writer.println("\t],");
    writer.println();

    writer.println("\t\"pops\": [");
    for(int i = 0; i < numLines; i++)
      writer.println("\t\t\"" + pops[i] + "\",");
    writer.println("\t\t\"" + pops[numLines - 1] + "\"");
    writer.println("\t],");
    writer.println();
    
    writer.println("\t\"logPops\": [");
    for(int i = 0; i < numLines; i++)
      writer.println("\t\t\"" + logPops[i] + "\",");
    writer.println("\t\t\"" + logPops[numLines - 1] + "\"");
    writer.println("\t],");
    writer.println();

    writer.println("\t\"ranks\": [");
    for(int i = 0; i < numLines; i++)
      writer.println("\t\t\"" + ranks[i] + "\",");
    writer.println("\t\t\"" + ranks[numLines - 1] + "\"");
    writer.println("\t],");
    writer.println();

    writer.println("\t\"logRanks\": [");
    for(int i = 0; i < numLines; i++)
      writer.println("\t\t\"" + logRanks[i] + "\",");
    writer.println("\t\t\"" + logRanks[numLines - 1] + "\"");
    writer.println("\t]");
    
    writer.println("}");

    writer.close();
  }
}
