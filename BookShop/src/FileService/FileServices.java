package FileService;

import javax.imageio.IIOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
This is a files service to do read and write operations with files.
 */
public class FileServices {
    /*
    reads from file by filename and returns String array
    every element is one line from that file
     */
    public String[] read(String filename) {
        String[] arr = null;
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            try {
                while ((line = br.readLine()) != null) {

                    sb.append(line);
                    sb.append("\n");
                }
            } catch (IOException E3) {
                System.out.println("Couldn't read the next line !!");
            }
            fr.close();
            arr = sb.toString().split("\n");
        } catch (IOException E2) {
            System.out.println("Couldn't read the file!!");

        }
        return arr;

    }
    public void write(String str, String filename)
    {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Your file was created by name: " + file.getName());
            }
            try {
                FileWriter fileWrite = new FileWriter(file.getName(), true);
                BufferedWriter bw = new BufferedWriter(fileWrite);
                bw.write(str+"\n");
                bw.close();
                System.out.println("Everything    is ok!");
            } catch (IOException e1) {
                System.out.println("Cant write to file. Try again.");
            }

        } catch (IOException e) {
            System.out.println("Can't create that file. Try again.");
        }

    }


}
