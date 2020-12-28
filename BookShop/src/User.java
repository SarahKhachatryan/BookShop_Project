import FileService.FileServices;

import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
    private String fullName;
    private String username;
    private String email;
    private String password;

    public User(){};
    public User(String fullName, String username, String email, String password) {
        this.setFullName(fullName);
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {

        if (username.length() > 10 && checkUsername(username)) {

            this.username = username;
            return true;
        } else {

           return false;
        }
    }

    public boolean checkUsername(String username) {
        FileServices fs = new FileServices();
        String[] arrOfUsers = fs.read("Users");
        for (int i = 0; i < arrOfUsers.length; i++) {
            String[] arrOfProperties = arrOfUsers[i].split("-");
            if (arrOfProperties[1] == username) {
                return false;
            }
        }
        return true;
    }

    public String getEmail() {
        return email;
    }

    public User[] toUserArray() {
        FileServices fs = new FileServices();
        String[] arrOfUsers = fs.read("Users");
        User[] usersArray = new User[arrOfUsers.length];
        for (int i = 0; i < arrOfUsers.length; i++) {
            String[] arrOfProperties = arrOfUsers[i].split("-");
            usersArray[i]= new User();
            usersArray[i].setFullName(arrOfProperties[0]);
            usersArray[i].setUsername(arrOfProperties[1]);
            usersArray[i].setEmail(arrOfProperties[2]);
            usersArray[i].setPassword(arrOfProperties[3]);
        }
        return usersArray;
    }

    public boolean setEmail(String email) {
        String[] emailParts = email.split("@");
        if (emailParts.length == 2) {
            String[] arr= emailParts[1].split(Pattern.quote("."));//i dont know why but doesnt split by "." so I used this character
            if (arr.length==2) {
                this.email = email;
                return true;
            }

        }
        return false;
    }
    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if (password.length() >= 8) {
            int uppercaseCount = 0;
            int numbersCount = 0;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    uppercaseCount++;
                }
                if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                    numbersCount++;
                }
            }
            if (uppercaseCount == 2 && numbersCount == 3) {
                this.password = password;
                return true;
            } else {
              return false;
            }
        } else {
            return false;
        }
    }
}
