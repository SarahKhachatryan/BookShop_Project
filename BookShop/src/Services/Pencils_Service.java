package Services;

import FileService.FileServices;
import ProductTypes.Product;
import Products.Book;
import Products.Markers;
import Products.Pencils;

import java.util.HashMap;
import java.util.HashSet;

public final class Pencils_Service extends Product_Service implements ConvertingFunctions{

    public Pencils[] pencilsByColorCount1(Pencils[] arr)//from min to max
    {
        boolean notArranged = false;
        while (!notArranged) {
            notArranged = true;
            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i].getCountOfColors() > arr[i + 1].getCountOfColors()) {
                    Pencils temp2 = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp2;
                    notArranged = false;
                }
            }
        }
        return arr;
    }

    @Override
    public Pencils setFromString(String str) {
      Pencils p= new Pencils();
      String[] properties = str.split("-");
      p.setName(properties[0]);
      p.setPrice(Integer.parseInt(properties[1]));
      p.setCountOfColors(Integer.parseInt(properties[2]));
      return p;
    }

    @Override
    public Pencils[] toArray(String filename) {

        FileServices fs = new FileServices();
        String[] arr = fs.read(filename);
        Pencils[] pencilsArray = new Pencils[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pencilsArray[i] = setFromString(arr[i]);
        }
        return pencilsArray;
    }
}
