import java.util.Objects;

public class Goodie {
  private String name;
  private float price;

  public Goodie() {
  }

  public Goodie(String name, float price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Goodie)) {
      return false;
    }
    Goodie goodie = (Goodie) o;
    return getName().equals(goodie.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
}
