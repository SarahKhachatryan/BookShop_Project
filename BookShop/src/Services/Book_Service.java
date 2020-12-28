package Services;

import FileService.FileServices;
import ProductTypes.Product;
import Products.Book;

import java.util.HashMap;
import java.util.HashSet;

public final class Book_Service extends Product_Service implements ConvertingFunctions {

    /*
        Creates and returns Book object from a given string.
         */
    public Book setFromString(String str) {
        Book b = new Book();
        String[] properties = str.split("-");
        b.setName(properties[0]);
        b.setPrice(Integer.parseInt(properties[1]));
        b.setYear(Integer.parseInt(properties[2]));
        b.setAuthor(properties[3]);
        b.setLanguage(properties[4]);
        return b;
    }

    /*
    Creates and returns array of books reading from file
     */
    public Book[] toArray(String fileName) {

        FileServices fs = new FileServices();
        String[] arr = fs.read(fileName);
        Book[] bookArray = new Book[arr.length];
        for (int i = 0; i < arr.length; i++) {
            bookArray[i] = setFromString(arr[i]);
        }
        return bookArray;

    }

    /*
    Searches Books with specified language.
     */
    public void printByLanguage(String genre, String language) {
        FileServices fs = new FileServices();
        String filename = genre + ".txt";
        Book_Service bs= new Book_Service();
        Book[] arr= toArray(filename);
        HashMap<String, HashSet<Book>> h= new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            HashSet<Book> s= new HashSet<>();
            h.put(arr[i].getLanguage(),s);
        }
        for(int i=0;i<arr.length;i++)
        {
            h.get(arr[i].getLanguage()).add(arr[i]);
        }

        System.out.println(h.get(language));
    }

    public Book[] booksByYear(Book[] arr)//from min to max
    {
        boolean notArranged = false;
        while (!notArranged) {
            notArranged = true;
            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i].getYear() > arr[i + 1].getYear()) {
                    Book temp2 = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp2;
                    notArranged = false;
                }
            }
        }
        return arr;
    }

    public Book[] booksByPages(Book[] arr)//from min to max
    {
        boolean notArranged = false;
        while (!notArranged) {
            notArranged = true;
            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i].getPages() > arr[i + 1].getPages()) {
                    Book temp2 = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp2;
                    notArranged = false;
                }
            }
        }
        return arr;
    }
    public void printByAuthor(String genre, String Author) {
        FileServices fs = new FileServices();
        String filename = genre + ".txt";
        Book[] arr= toArray(filename);
        HashMap<String, HashSet<Book>> h= new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            HashSet<Book> s= new HashSet<>();
            h.put(arr[i].getAuthor(),s);
        }
        for(int i=0;i<arr.length;i++)
        {
            h.get(arr[i].getAuthor()).add(arr[i]);
        }

        System.out.println(h.get(Author));
    }
}
