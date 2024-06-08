package impl;

import db.DataBase;
import exception.MyException;
import models.Post;
import models.User;
import services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    private DataBase dataBase= new DataBase();
    private Long userId=1L;




    public UserServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String register(User user) {
        dataBase.getUsers().add(user);
        user.setId(userId++);
        return "Register successfully done";
    }

    @Override
    public String login(String login, String password) {
        PostServiceImpl postService= new PostServiceImpl(dataBase);
        Scanner scanner= new Scanner(System.in);
        Scanner scannerForString=new Scanner(System.in);
        try {
            int num;
            for (User sign : dataBase.getUsers()) {
                if (sign.getEmail().equals(login) && sign.getPassword().equals(password)) {
                    while (true) {
                        System.out.println("""
                                1.Add post
                                2.Delete post
                                3.Get all post
                                4.Get User by email
                                5.Get all Users
                                0.Log out""");
                        num = scanner.nextInt();
                        switch (num) {
                            case 1:
                                System.out.println("Write User ID:");
                                Long id = scanner.nextLong();
                                System.out.println("Download image");
                                String image = scannerForString.nextLine();
                                System.out.println("Write description");
                                String description = scannerForString.nextLine();
                                Post ps = new Post(image, description);
                                System.out.println(postService.addPostToUser(id, ps));
                                break;
                            case 2:
                                System.out.println("write Post id to deleting");
                                Long idPost = scanner.nextLong();
                                System.out.println(postService.deletePostById(idPost));
                                System.out.println(dataBase.getPosts());
                                break;
                            case 3:
                                System.out.println("Write User id to get all posts");
                                Long userIdToGetPost = scanner.nextLong();
                                System.out.println(postService.getAllPostByUserId(userIdToGetPost));
                                break;
                            case 4:
                                System.out.println("Write User`s email to find");
                                String emai = scannerForString.nextLine();
                                System.out.println(getUserByEmail(emai));
                                break;
                            case 5:
                                System.out.println(getAllUsers());
                                break;
                            case 0:
                                return " ";
                            default:
                                System.out.println("Invalid");
                        }
                    }


                }

            }
            throw new MyException();

        }catch (MyException myException){
            System.out.println("Login or password incorrect");
        }
        return "Log in failed";
    }

    @Override
    public User getUserByEmail(String email) {
        User newUser = new User();
        try {
            for (User a : dataBase.getUsers()) {
                if (a.getEmail().equals(email)) {
                    newUser = a;
                    return newUser;
                }
            }
            throw new MyException();
        }catch (MyException myException){
            System.out.println("Not found User email");
        }
        return newUser ;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            if (!dataBase.getUsers().isEmpty()) {
                return dataBase.getUsers();
            }

            throw new MyException();
        }catch (MyException myException){
            System.out.println("There are no users");
        } return new ArrayList<>();
    }
}
