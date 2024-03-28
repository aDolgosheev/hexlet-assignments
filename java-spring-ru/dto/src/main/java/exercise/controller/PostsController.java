package exercise.controller;

import exercise.dto.CommentDTO;
import exercise.dto.PostDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.model.Post;
import exercise.repository.CommentRepository;
import exercise.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<PostDTO> index() {
        var list = postRepository.findAll();
        return list.stream().map(this::toPostDTO).toList();
    }

    private PostDTO toPostDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        var comments = commentRepository.findByPostId(post.getId());
        var commentsDTO = comments.stream()
                .map(comment -> {
                    var commentDTO = new CommentDTO();
                    commentDTO.setBody(comment.getBody());
                    commentDTO.setId(comment.getId());
                    return commentDTO;
                })
                .toList();
        dto.setComments(commentsDTO);
//        dto.setBody(
//                commentRepository.findByPostId(post.getId()).stream().toList().toString()
//        );
        return dto;
    }

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

//        var dto = new PostDTO();

        return toPostDTO(post);
    }
}

// END
