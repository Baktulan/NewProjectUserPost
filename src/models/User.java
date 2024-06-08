package models;

import enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private Gender gender;
    private List<Post> posts= new ArrayList<>();

    public User() {
    }

    public User(Long id ,String fullName, String email, String password, Gender gender, List<Post> posts) {
        this.id=id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.posts = posts;
    }

    public User(String fullName, String email, String password, Gender gender) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public User(Long id, String fullName, String email, String password, Gender gender) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User " +"\n"+
                "id: " + id+ "\n"+
                "fullName: " + fullName + "\n" +
                "email: " + email + "\n" +
                "password: " + password + "\n" +
                "gender: " + gender +"\n"+
                "posts: " + posts +"\n";
    }
}
