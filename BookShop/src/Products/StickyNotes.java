package Products;

import ProductTypes.ToWriteInProducts;

public final class StickyNotes extends ToWriteInProducts {
    private int quantity;
    private String color;

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(super.toString()).append("--").append(getColor()).append("--").append(getQuantity());
        return sb.toString();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}