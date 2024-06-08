package impl;

import db.DataBase;
import exception.MyException;
import models.Post;
import models.User;
import services.PostService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PostServiceImpl implements PostService {
    private  DataBase dataBase =new DataBase();
    private Long postID=1L;

    public PostServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public String addPostToUser(Long userId, Post post) {
        try{
            for (User user : dataBase.getUsers()) {
                if (user.getId().equals(userId)){
                    post.setId(postID++);
                    user.getPosts().add(post);
                    dataBase.getPosts().add(post);
                    return "Successfully added to user";
                }
            }
            throw new MyException();
        }catch (MyException e){
            System.out.println("User id not found");
        }
        return "Please try again";
    }

    @Override
    public String deletePostById(Long postId) {
        try {
            Iterator<Post> iterator = dataBase.getPosts().iterator();
            while (iterator.hasNext()) {
                Post post = iterator.next();
                if (post.getId().equals(postId)) {
                    iterator.remove();
                    return "Post successfully deleted!";
                }
            }
            for (User user : dataBase.getUsers()) {
                Iterator<Post>iterator1=user.getPosts().iterator();
                while(iterator1.hasNext()){
                    Post post=iterator1.next();
                    if (post.getId().equals(postId)){
                        iterator1.remove();
                        return "Also deleted from user";
                    }
                }
            }
            throw new MyException();
        } catch (MyException e) {
            System.out.println("Post id not found");
        }
        return "Please write id correctly";
    }

    @Override
    public List<Post> getAllPostByUserId(Long userId) {
        try {
            for (User posts : dataBase.getUsers()) {
                if (posts.getId().equals(userId)) {
                    return posts.getPosts();
                }
            }
            throw new MyException();
        }catch (MyException e){
            System.out.println("User Id not found ");
        }
        return new ArrayList<>();
    }
}
