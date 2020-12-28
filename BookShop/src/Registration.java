import FileService.FileServices;
import java.util.HashSet;
import java.util.Set;

public class Registration {

  public void addUser(User u)
   {
       FileServices fs = new FileServices();
       StringBuilder sb = new StringBuilder();
       sb.append(u.getFullName()).append("-").append(u.getUsername()).append("-").append(u.getEmail()).append("-").append(u.getPassword());
       fs.write(sb.toString(), "Users");

   }

}
