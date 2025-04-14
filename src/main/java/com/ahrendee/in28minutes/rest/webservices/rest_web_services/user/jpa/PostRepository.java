package com.ahrendee.in28minutes.rest.webservices.rest_web_services.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahrendee.in28minutes.rest.webservices.rest_web_services.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
