package com.ahrendee.in28minutes.rest.webservices.rest_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ahrendee.in28minutes.rest.webservices.rest_web_services.user.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserResource {

    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable int id) {
        User user = userDaoService.findById(id);
        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        // EntityModel<User> model = EntityModel.of(user);
        // WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAll());
        // model.add(link.withRel("all-users"));

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable int id) {
        userDaoService.deleteById(id);
    }
}
