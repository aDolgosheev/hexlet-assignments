package exercise.controller;

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

    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> index() {
        var list = postRepository.findAll();
        return list.stream().map(this::toDTO).toList();
    }

    private PostDTO toDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
//        dto.setBody(post.getBody());
        dto.setBody(
                commentRepository.findByPostId(post.getId()).stream().toList().toString()
        );
        return dto;
    }

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));

//        var dto = new PostDTO();

        return toDTO(post);
    }
}

// END
