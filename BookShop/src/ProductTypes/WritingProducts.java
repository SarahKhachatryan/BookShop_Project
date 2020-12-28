package ProductTypes;
public class WritingProducts extends Product {
   private String color;
    private String mark;

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(super.toString()).append("--").append(getColor()).append("--").append(getMark()).append("--");
       return sb.toString();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
