import FileService.FileServices;

public class Login {

   public boolean login(String username, String password) {
        User u = new User();
            User[] userArr = u.toUserArray();
            for(int i=0;i<userArr.length;i++)
            {
                if(userArr[i].getUsername().compareTo(username)==0)
                {
                    if(userArr[i].getPassword().compareTo(password)==0)
                    {
                        System.out.println("Valid User!!");
                        return true;
                    }
                    else {
                        System.out.println("Wrong password!");
                        return false;
                    }
                }
            }

       System.out.println("Invalid user!!");
       return false;
    }

}
