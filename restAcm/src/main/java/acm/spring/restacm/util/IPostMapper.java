package acm.spring.restacm.util;

import acm.spring.restacm.dto.PostDTO;
import acm.spring.restacm.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPostMapper {

    @Mapping(source = "identificador",target = "id")
    Post dtoToModel(PostDTO postDTO);

    PostDTO modelToDto(Post post);

}
