package acm.spring.restacm.service;

import acm.spring.restacm.dto.PostDTO;
import acm.spring.restacm.models.Post;

import java.util.List;

public interface IPostService {
    List<Post> getAllPosts();

    Post createPost(PostDTO postDTO);

    Post getPostById(Long id);

    void deletePostById(Long id);
}
