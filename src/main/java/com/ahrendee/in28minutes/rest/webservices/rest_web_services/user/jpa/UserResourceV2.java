package com.ahrendee.in28minutes.rest.webservices.rest_web_services.user.jpa;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ahrendee.in28minutes.rest.webservices.rest_web_services.user.Post;
import com.ahrendee.in28minutes.rest.webservices.rest_web_services.user.User;
import com.ahrendee.in28minutes.rest.webservices.rest_web_services.user.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserResourceV2 {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserResourceV2(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/v2/users")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/v2/users/{id}")
    public User findById(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
        return user.get();
    }

    @PostMapping("/v2/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User newUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/v2/users/{id}")
    public void deleteById(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/v2/users/{id}/posts")
    public List<Post> findPostsByUserId(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("user id: " + id);
        }
        return user.get().getPosts();
    }

    @PostMapping("/v2/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("user id: " + id);
        }
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
