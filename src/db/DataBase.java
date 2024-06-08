package db;

import models.Post;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<User>users= new ArrayList<>();
    private List<Post>posts= new ArrayList<>();

    public DataBase() {
    }

    public DataBase(List<User> users, List<Post> posts) {
        this.users = users;
        this.posts = posts;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
