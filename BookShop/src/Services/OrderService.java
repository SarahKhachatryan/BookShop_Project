package Services;

import FileService.FileServices;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class OrderService {
    public void makeOrder(String type, String name) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
       // System.out.println(formatter.format(date));
        FileServices fs = new FileServices();
        StringBuilder sb = new StringBuilder();
        sb.append("Product: ").append(type).append("  Name: ").append(name).append("  Order Time: ").append(formatter.format(date));
        fs.write(sb.toString(), "Orders.txt");
    }

}
