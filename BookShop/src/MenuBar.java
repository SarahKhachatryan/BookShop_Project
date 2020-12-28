import FileService.FileServices;
import Products.*;
import Services.*;

import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class MenuBar {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Hi Dear costumer.... You are in Sarah's BookShop...");
        System.out.println("If you want to register in our shop press 1");
        System.out.println("If you want to Login to your existing account press 2");
        int signUpOrIn = s.nextInt();
        if (signUpOrIn == 1) {
            User u = new User();
            System.out.println("FullName: ");
            String fullName = s.next();
            System.out.println("Username: ");
            String username = s.next();
            while (!u.setUsername(username)) {
                System.out.println("Wrong username please enter once!");
                username = s.next();
            }
            System.out.println("Email: ");
            String email = s.next();
            while (!u.setEmail(email)) {
                System.out.println("Wrong email please enter once!");
                email = s.next();
            }
            System.out.println("Password: ");
            String password = s.next();
            while (!u.setPassword(password)) {
                System.out.println("Wrong password please enter once!");
                password = s.next();
            }
            Registration register = new Registration();
            register.addUser(new User(fullName, username, email, password));
        }

        else if (signUpOrIn == 2) {
            System.out.println("Enter your username.");
            String username = s.next();
            System.out.println("Enter your password.");
            String password = s.next();
            Login l = new Login();
            while (!l.login(username, password)) {
                System.out.println("Enter your username.");
                username = s.next();
                System.out.println("Enter your password.");
                password = s.next();
            }
        }
        int input0 = 1;
        while (input0 == 1) {
        System.out.println("How can I help you?");
        System.out.println("1.I want to make an order.");
        System.out.println("2.I would like to find a product.");
        int n = s.nextInt();
        if (n == 1) {
            System.out.println("Please Write the Product Type.");
            String type = s.next();
            System.out.println("Please Write the Product Name.");
            String name = s.next();
            OrderService os = new OrderService();
            os.makeOrder(type, name);
            System.out.println("Your order was made! Thank you for choosing us:)");
        }
        if(n==2) {
            System.out.println("What product do you want?");
            System.out.println("1:Book");
            System.out.println("2:NoteBook");
            System.out.println("3:StickyNotes");
            System.out.println("4:Pencils");
            System.out.println("5:Pens");
            int input = s.nextInt();
                switch (input) {
                    case 1: {
                        System.out.println("How would you like to filter?");
                        System.out.println("Please Write the genre:)");
                        System.out.println("Fantasy,Adventure,Detective,Motivational or Romance");
                        String genre = s.next();
                        String filename = genre;
                        System.out.println("1:By Price From Min To Max");
                        System.out.println("2:By Price From Max To Min");
                        System.out.println("3:By Author");
                        System.out.println("4:By Year");
                        System.out.println("5:By Pages");
                        System.out.println("6:By Language");
                        Book_Service bs = new Book_Service();
                        Book[] booksArray = bs.toArray(filename);
                        int input1 = s.nextInt();
                        switch (input1) {
                            case 1: {
                                bs.Print(bs.productsByPrice1(booksArray));
                            }
                            break;
                            case 2: {
                                bs.Print(bs.productsByPrice2(booksArray));
                            }
                            break;
                            case 3: {
                                System.out.println("Please write your desired author");
                                String author = s.next();
                                bs.printByAuthor(genre, author);
                            }
                            break;
                            case 4: {
                                bs.Print(bs.booksByYear(booksArray));
                            }
                            break;
                            case 5: {
                                bs.Print(bs.booksByPages(booksArray));
                            }
                            break;
                            case 6: {
                                System.out.println("Please write your desired language");
                                String language = s.next();
                                bs.printByLanguage(genre, language);
                            }
                        }
                    }
                    break;
                    case 2: {
                        System.out.println("How would you like to filter?");
                        System.out.println("1:By Price From Min To Max");
                        System.out.println("2:By Price From Max To Min");
                        System.out.println("3:By Pages");
                        int input2 = s.nextInt();
                        Notebook_Service ns = new Notebook_Service();
                        NoteBook[] nbArray = ns.toArray("NoteBooks");
                        switch (input2) {
                            case 1: {
                                ns.Print(ns.productsByPrice1(nbArray));
                            }
                            break;
                            case 2: {
                                ns.Print(ns.productsByPrice2(nbArray));
                            }
                            break;
                            case 3: {
                                ns.Print(ns.notebooksByPages(nbArray));
                            }
                            break;
                        }

                    }
                    break;
                    case 3: {
                        System.out.println("How would you like to filter?");
                        System.out.println("1:By Price From Min To Max");
                        System.out.println("2:By Price From Max To Min");
                        System.out.println("3:By Quantity");
                        int input2 = s.nextInt();
                        StickyNotes_Service sns = new StickyNotes_Service();
                        StickyNotes[] snArray = sns.toArray("StickyNotes");
                        switch (input2) {
                            case 1: {
                                sns.Print(sns.productsByPrice1(snArray));
                            }
                            break;
                            case 2: {
                                sns.Print(sns.productsByPrice2(snArray));
                            }
                            break;
                            case 3: {
                                sns.Print(sns.snByQuantity(snArray));
                            }
                            break;
                        }
                    }
                    break;
                    case 4: {
                        System.out.println("How would you like to filter?");
                        System.out.println("1:By Price From Min To Max");
                        System.out.println("2:By Price From Max To Min");
                        System.out.println("3:By colors count");
                        int input2 = s.nextInt();
                        Pencils_Service ps = new Pencils_Service();
                        Pencils[] pArray = ps.toArray("Pencils");
                        switch (input2) {
                            case 1: {
                                ps.Print(ps.productsByPrice1(pArray));
                            }
                            break;
                            case 2: {
                                ps.Print(ps.productsByPrice2(pArray));
                            }
                            break;
                            case 3: {
                                ps.Print(ps.pencilsByColorCount1(pArray));
                            }
                            break;
                        }
                    }
                    break;
                    case 5: {
                        System.out.println("How would you like to filter?");
                        System.out.println("1:By Price From Min To Max");
                        System.out.println("2:By Price From Max To Min");
                        System.out.println("3:By size");
                        int input2 = s.nextInt();
                        Pens_Service ps = new Pens_Service();
                        Pens[] pArray = ps.toArray("Pens");
                        switch (input2) {
                            case 1: {
                                ps.Print(ps.productsByPrice1(pArray));
                            }
                            break;
                            case 2: {
                                ps.Print(ps.productsByPrice2(pArray));
                            }
                            break;
                            case 3: {
                                ps.Print(ps.pensBySize1(pArray));
                            }
                            break;
                        }
                    }
                    break;

                }
            }
            System.out.println("If you want to continue watching write 1");
            input0=s.nextInt();
        }

   }
}
