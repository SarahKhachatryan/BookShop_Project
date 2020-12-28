package ProductTypes;

public class Product {
    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(getName()).append("--").append(getPrice()).append("--");
        return sb.toString();
    }

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
