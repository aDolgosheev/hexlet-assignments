package exercise.controller.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api/users/{id}/posts")
public class PostsController {

    private List<Post> posts = Data.getPosts();

    @GetMapping
    public List<Post> index(@PathVariable String id) {
        return posts.stream()
                .filter(p -> p.getUserId() == Integer.parseInt(id))
                .toList();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Post create(@RequestBody Post post, @PathVariable String id) {
        post.setUserId(Integer.parseInt(id));
        posts.add(post);
        return post;
    }
}
// END
