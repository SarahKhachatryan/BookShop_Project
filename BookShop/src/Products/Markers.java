package Products;

import ProductTypes.Product;
import ProductTypes.WritingProducts;

public final class Markers extends WritingProducts {
    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(super.toString()).append("--").append(getSize());
        return  sb.toString();
    }

    private double size;
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
