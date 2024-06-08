import db.DataBase;
import enums.Gender;
import impl.PostServiceImpl;
import impl.UserServiceImpl;
import models.Post;
import models.User;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        UserServiceImpl userService = new UserServiceImpl(dataBase);
        PostServiceImpl postService = new PostServiceImpl(dataBase);
        Scanner scanner = new Scanner(System.in);
        Scanner scannerForString= new Scanner(System.in);
        int number;
        while (true) {
            System.out.println("Welcome User!!"+"\n"+"If you don`t have account press 1 to REGISTER"+
                    "\n"+"if you already have account press 2 to LOG IN"+"\n"+"Press 3 to get all Users");
            number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println("Write full name:");
                    String fullName=scannerForString.nextLine();
                    System.out.println("Write email");
                    String email=scannerForString.nextLine();
                    System.out.println("Write password");
                    String password= scannerForString.nextLine();
                    System.out.println("Write your gender MALE || FEMALE");
                    String gender= scannerForString.nextLine().toUpperCase();
                    User use= new User(fullName,email,password,Gender.valueOf(gender));
                    System.out.println(userService.register(use));
                    break;
                case 2:
                    System.out.println("Write email:");
                    String email1=scannerForString.nextLine();
                    System.out.println("Write password");
                    String password1=scannerForString.nextLine();
                    System.out.println(userService.login(email1, password1));
                    break;
                case 3:
                    System.out.println(userService.getAllUsers());
                    break;
                default:
                    System.out.println("Invalid , please try again");


            }
        }

    }
}