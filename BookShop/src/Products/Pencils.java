package Products;
import ProductTypes.WritingProducts;

public final class Pencils extends WritingProducts {
    private int countOfColors;

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(super.toString()).append("--").append(getCountOfColors());
        return sb.toString();
    }


    @Override
    public void setColor(String color) {
        super.setColor("MULTICOLORED");
    }

    public int getCountOfColors() {
        return countOfColors;
    }

    public void setCountOfColors(int countOfColors) {
        this.countOfColors = countOfColors;
    }
}
