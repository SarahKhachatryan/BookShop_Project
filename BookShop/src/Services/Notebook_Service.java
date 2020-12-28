package Services;

import FileService.FileServices;
import ProductTypes.Product;
import Products.Book;
import Products.NoteBook;
import Products.Pens;
import java.util.HashMap;
import java.util.HashSet;

public final  class Notebook_Service extends Product_Service implements ConvertingFunctions{

    public NoteBook[] notebooksByPages(NoteBook[] arr)//from min to max
    {
        boolean notArranged = false;
        while (!notArranged) {
            notArranged = true;
            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i].getPages() > arr[i + 1].getPages()) {
                    NoteBook temp2 = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp2;
                    notArranged = false;
                }
            }
        }
        return arr;
    }

    @Override
    public NoteBook setFromString(String str) {
        NoteBook nb= new NoteBook();
        String[] properties = str.split("-");
        nb.setName(properties[0]);
        nb.setPrice(Integer.parseInt(properties[1]));
        nb.setMark(properties[2]);
        nb.setType(properties[3]);
        nb.setPages(Integer.parseInt(properties[4]));
        return nb;
    }

    @Override
    public NoteBook[] toArray(String filename) {
        FileServices fs = new FileServices();
        String[] arr = fs.read(filename);
        NoteBook[] notebookArray = new NoteBook[arr.length];
        for (int i = 0; i < arr.length; i++) {
            notebookArray[i] = setFromString(arr[i]);
        }
        return notebookArray;

    }
}
