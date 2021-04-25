import java.util.List;

public class GoodiesPickerMain {
  public static void main(String[] args) {
    System.out.println("Working");

    String filename = "sample_input.txt";
    List<String> stringList = ReadFileIntoList.readFileInList(filename);

    //    as per sample_input.txt file
    //    No of employee info at first line
    int noOfEmplyoyees = GoodiesUtils.getNoOfEmployees(stringList.get(0));

    //    Goodies and price info starts at 5th line
    List<Goodie> goodieList = GoodiesUtils.readGoodies(stringList.subList(4, stringList.size()));

    GoodiesPicker goodiesPicker = new GoodiesPicker(goodieList);

    List<Goodie> goodiesForEmployees = goodiesPicker.getGoodiesForEmployees(noOfEmplyoyees);

    GoodiesUtils.writeOutputToFile(goodiesForEmployees,goodiesPicker.getMinDifference());

    System.out.println("Ended");
  }


}
