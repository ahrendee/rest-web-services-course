package com.ahrendee.in28minutes.rest.webservices.rest_web_services.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "Description should have at least 2 characters")
    @JsonProperty("description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post() {
        super();
    }

    // public Post(Integer id, String name, LocalDate birthDate) {
    // this.id = id;
    // this.name = name;
    // this.birthDate = birthDate;
    // }
}
