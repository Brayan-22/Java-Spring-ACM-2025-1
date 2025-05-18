package acm.spring.restacm.util;


import acm.spring.restacm.dto.PostDTO;
import acm.spring.restacm.models.Post;

import java.util.List;

public class PostMapper {
    private PostMapper() {}
    public static PostDTO modelToDto(Post post) {
        return PostDTO.builder()
                .identificador(post.getId())
                .titulo(post.getTitle())
                .cuerpo(post.getBody())
                .usuarioId(post.getUserId())
                .build();
    }

    public static Post dtoToModel(PostDTO postDTO) {
        return Post.builder()
                .id(postDTO.getIdentificador())
                .title(postDTO.getTitulo())
                .body(postDTO.getCuerpo())
                .userId(postDTO.getUsuarioId())
                .build();
    }

    public static List<PostDTO> modelListToDtoList(List<Post> posts) {
        return posts.stream()
//                .map(post -> {return modelToDto(post);})
                .map(PostMapper::modelToDto)
                .toList();
    }

    public static List<Post> dtoListToModelList(List<PostDTO> postDTOS) {
        return postDTOS.stream()
                .map(PostMapper::dtoToModel)
                .toList();
    }
}
