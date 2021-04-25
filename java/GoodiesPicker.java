import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GoodiesPicker {
  private List<Goodie> sortedGoodieList = new ArrayList<>();

  private float minDifference;

  public GoodiesPicker(List<Goodie> goodieList) {
    if(goodieList != null) {
      this.sortedGoodieList = goodieList.stream().sorted(Comparator.comparingDouble(Goodie::getPrice)).collect(
          Collectors.toList());
    }
  }


  public List<Goodie>  getGoodiesForEmployees(int noOfEmployees) {
    List<Goodie> goodieList = new ArrayList<>();
    float min = Float.MAX_VALUE ;

    int fromIndex = -1;
    int toIndex = -1;

    int maxIndex = sortedGoodieList.size();
    for (int i=0;i<maxIndex;i++) {
      int x = i;
      int y = i+ noOfEmployees-1;
      if(y >= maxIndex) break;

      float v1 = sortedGoodieList.get(x).getPrice();
      float v2 = sortedGoodieList.get(y).getPrice();

      float diff = v2- v1;
      if (diff < min ) {
        min = diff;
        fromIndex = x;
        toIndex = y;
      }
    }

    if (fromIndex != -1 && toIndex != -1) {
      minDifference = min;
      goodieList = sortedGoodieList.subList(fromIndex,toIndex+1);
    }

    return  goodieList;
  }

  public float getMinDifference() {
    return minDifference;
  }
}
