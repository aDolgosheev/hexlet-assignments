package exercise.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
public class PostDTO {

    private List<CommentDTO> comments;

    private long id;

    private String title;

    private String body;
}

// END
