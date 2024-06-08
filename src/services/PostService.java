package services;

import models.Post;

import java.util.List;

public interface PostService {
    String addPostToUser(Long userId,Post post);
    String deletePostById(Long postId);
    List<Post>getAllPostByUserId(Long userId);

}
