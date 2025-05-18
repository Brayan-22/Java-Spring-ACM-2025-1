package acm.spring.restacm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {
    @JsonProperty("userId")
    private Long usuarioId;
    @JsonProperty("id")
    private Long identificador;
    @JsonProperty("title")
    private String titulo;
    @JsonProperty("body")
    private String cuerpo;
}
