package course.springdata.restMVC.web;

import course.springdata.restMVC.dao.PostRepository;
import course.springdata.restMVC.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @GetMapping
    public Collection<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post getAllPosts(@PathVariable Long id){
        return postRepository.findById(id).orElseThrow();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost(@RequestBody Post post){
        return postRepository.save(post);
    }

}
