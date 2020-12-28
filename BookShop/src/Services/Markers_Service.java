package Services;

import FileService.FileServices;
import ProductTypes.Product;
import ProductTypes.WritingProducts;
import Products.Book;
import Products.Markers;

import java.util.HashMap;
import java.util.HashSet;

public final class Markers_Service extends WritingProducts implements ConvertingFunctions{
    public Markers[] markersBySize1(Markers[] arr)//from min to max
    {
        boolean notArranged = false;
        while (!notArranged) {
            notArranged = true;
            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i].getSize() > arr[i + 1].getSize()) {
                    Markers temp2 = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp2;
                    notArranged = false;
                }
            }
        }
return arr;
    }
    public Markers[] markersBySize2(Markers[] arr)//from max to min
    {
        boolean notArranged = false;
        while (!notArranged) {
            notArranged = true;
            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i].getSize() <arr[i + 1].getSize()) {
                    Markers temp2 = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp2;
                    notArranged = false;
                }
            }
        }
        return arr;
    }

    @Override
    public  Markers setFromString(String str) {
        Markers m= new Markers();
        String[] properties = str.split("-");
         m.setName(properties[0]);
         m.setPrice(Integer.parseInt(properties[1]));
         m.setColor(properties[2]);
         m.setMark(properties[3]);
         m.setSize(Double.parseDouble(properties[4]));
         return m;
    }

    @Override
    public Markers[] toArray(String filename) {
        filename="Markers.txt";
        FileServices fs = new FileServices();
        String[] arr = fs.read(filename);
        Markers[] markersArray = new Markers[arr.length];
        for (int i = 0; i < arr.length; i++) {
            markersArray[i] = setFromString(arr[i]);
        }
        return markersArray;
    }
}
