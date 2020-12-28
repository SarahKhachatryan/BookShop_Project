package Services;

import Comparators.PriceComparator;
import FileService.FileServices;
import ProductTypes.Product;
import Products.Book;
import Products.Markers;

public class Product_Service  {

    public void Print(Product[] arr )
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i].toString());
        }
    }

    public Product[] productsByPrice1(Product[] arr)//from min to max
    {
        boolean notArranged = false;
        while (!notArranged) {
            notArranged = true;
            for (int i = 0; i < arr.length - 1; i++) {
                PriceComparator pc = new PriceComparator();
                if (pc.compare(arr[i],arr[i+1])>0) {
                    Product temp2 = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp2;
                    notArranged = false;
                }
            }
        }
        return arr;
    }
    public Product[] productsByPrice2(Product[] arr)//from min to max
    {
        boolean notArranged = false;
        while (!notArranged) {
            notArranged = true;
            for (int i = 0; i < arr.length - 1; i++) {
                PriceComparator pc = new PriceComparator();
                if (pc.compare(arr[i],arr[i+1])<0) {
                    Product temp2 = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp2;
                    notArranged = false;
                }
            }
        }
        return arr;
    }
}
