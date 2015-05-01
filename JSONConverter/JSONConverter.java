import java.io.*;
import java.util.*;

public class JSONConverter {
  public static void main(String[] args) {
    Scanner input = null;
    FileWriter output = null;
    try {
      input = new Scanner(new File(args[0] + ".tsv"));
      FileWriter output = new FileWriter(args[0] + ".json");
    } catch(IOException e) {
      e.printStackTrace();
    }
    String names[] = new String[args[1]];
    String 
  }
}
