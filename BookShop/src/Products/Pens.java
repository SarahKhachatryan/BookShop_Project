package Products;

import ProductTypes.WritingProducts;

public final class Pens extends WritingProducts {
    private int size;
    private boolean gel;//true is a gel pen, false not a gel pen

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("--").append(getSize()).append("--").append(isGel()?"gel":"notgel");
        return sb.toString();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isGel() {
        return gel;
    }

    public void setGel(boolean gel) {
        this.gel = gel;
    }
}
