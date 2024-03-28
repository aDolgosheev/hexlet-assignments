package exercise.dto;

import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
public class CommentDTO {

    private long id;

    private long postId;

    private String body;
}

// END
