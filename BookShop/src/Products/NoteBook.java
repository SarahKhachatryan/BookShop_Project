package Products;

import ProductTypes.ToWriteInProducts;

public final class NoteBook extends ToWriteInProducts {
    private int pages;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("--").append(getPages()).append("--");
        return sb.toString();
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}
