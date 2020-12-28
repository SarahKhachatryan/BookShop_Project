package Services;

import FileService.FileServices;
import ProductTypes.Product;
import Products.Markers;
import Products.Pencils;
import Products.Pens;

import java.util.HashMap;
import java.util.HashSet;

public final class Pens_Service extends Product_Service implements ConvertingFunctions{

    public Pens[] pensBySize1(Pens[] arr)//from min to max
    {
        boolean notArranged = false;
        while (!notArranged) {
            notArranged = true;
            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i].getSize() > arr[i + 1].getSize()) {
                    Pens temp2 = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp2;
                    notArranged = false;
                }
            }
        }
        return arr;
    }

    @Override
    public Pens setFromString(String str) {
        Pens p= new Pens();
        String[] properties = str.split("-");
        p.setName(properties[0]);
        p.setPrice(Integer.parseInt(properties[1]));
        p.setGel(Boolean.parseBoolean(properties[2]));
        p.setSize(Integer.parseInt(properties[3]));
        p.setMark(properties[4]);
        p.setColor(properties[5]);
        return p;
    }

    @Override
    public Pens[] toArray(String filename) {

        FileServices fs = new FileServices();
        String[] arr = fs.read(filename);
        Pens[] pensArray = new Pens[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pensArray[i] = setFromString(arr[i]);
        }
        return pensArray;
    }
}
