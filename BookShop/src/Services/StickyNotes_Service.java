package Services;

import FileService.FileServices;
import ProductTypes.Product;
import Products.NoteBook;
import Products.Pencils;
import Products.StickyNotes;

public final class StickyNotes_Service extends Product_Service implements ConvertingFunctions {
    public StickyNotes[] snByQuantity(StickyNotes[] arr)//from min to max
    {
        boolean notArranged = false;
        while (!notArranged) {
            notArranged = true;
            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i].getQuantity() > arr[i + 1].getQuantity()) {
                    StickyNotes temp2 = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp2;
                    notArranged = false;
                }
            }
        }
        return arr;
    }
    @Override
    public StickyNotes setFromString(String str) {
          StickyNotes p= new StickyNotes();
        String[] properties = str.split("-");
        p.setName(properties[0]);
        p.setPrice(Integer.parseInt(properties[1]));
        p.setType(properties[2]);
        p.setMark(properties[3]);
        p.setQuantity(Integer.parseInt(properties[4]));
        p.setColor(properties[5]);
        return p;
    }

    @Override
    public StickyNotes[] toArray(String filename) {

        FileServices fs = new FileServices();
        String[] arr = fs.read(filename);
      StickyNotes[]  Array = new StickyNotes[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Array[i] = setFromString(arr[i]);
        }
        return Array;
    }
}
