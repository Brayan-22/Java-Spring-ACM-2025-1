package acm.spring.restacm.service.impl;

import acm.spring.restacm.dto.PostDTO;
import acm.spring.restacm.models.Post;
import acm.spring.restacm.service.IPostService;
import acm.spring.restacm.util.IPostMapper;
import acm.spring.restacm.util.IPostMapperImpl;
import acm.spring.restacm.util.PostMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements IPostService {

//    @Autowired
    private final RestTemplate restTemplate;


    private final IPostMapper mapper;

    @Override
    public List<Post> getAllPosts() {
        PostDTO[] postDTOS = restTemplate.getForObject("/posts", PostDTO[].class);
        if (postDTOS == null || postDTOS.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.stream(postDTOS).map(mapper::dtoToModel).toList();
    }

    @Override
    public Post createPost(PostDTO postDTO) {
        Post post = mapper.dtoToModel(postDTO);
        Post created = restTemplate.postForObject("/posts", post, Post.class);
        return created;
    }

    @Override
    public Post getPostById(Long id) {
        Post post = restTemplate.getForObject("/posts/" + id, Post.class);
        return post;
    }

    @Override
    public void deletePostById(Long id) {
        restTemplate.delete("/posts/" + id);
    }


//    @Autowired
//    public void setRestTemplate(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }



}
