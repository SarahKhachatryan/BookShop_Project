package ProductTypes;
public class ToWriteInProducts extends Product{
    private String type;//page's type
     private  String mark;

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(super.toString()).append("--").append(getType()).append("--").append(getMark()).append("--");
        return sb.toString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
