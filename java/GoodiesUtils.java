import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GoodiesUtils {
  public static List<Goodie> readGoodies(List<String> strings) {
    List<Goodie> goodieList = new ArrayList<>();
    for (String s : strings) {

      try {
        String[] split = s.split(":");

        String name = split[0];
        String priceString = split[1];
        float price = Float.valueOf(priceString);

        Goodie g = new Goodie(name, price);

        goodieList.add(g);
      } catch (Exception e) {
        //        do nothing
      }
    }

    return goodieList;
  }

  public static int getNoOfEmployees(String sampleInput) {
    int noOfEmployees = 0;

    try {
      String[] split = sampleInput.split(":");
      String fieldString = split[1];
      noOfEmployees = Integer.valueOf(fieldString.trim());
    } catch (Exception e) {
      e.printStackTrace();
    }

    return noOfEmployees;
  }

  public static void writeOutputToFile(List<Goodie> goodiesForEmployees, float minDiff) {
    String outputFile = "my_output.txt";

    try {
      FileWriter fw = new FileWriter(outputFile);

      PrintWriter printWriter = new PrintWriter(fw);

      printWriter.println("The goodies selected for distribution are:");
      printWriter.println("");

      for (Goodie g : goodiesForEmployees) {
        printWriter.println(g.getName() + ": " + g.getPrice());
      }

      printWriter.println("");

      printWriter.println(
          "And the difference between the chosen goodie with highest price and the lowest price is "
              + minDiff);
      printWriter.close();
      fw.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
