package com.synerix.Joblisting.controller;

import com.synerix.Joblisting.model.Post;
import com.synerix.Joblisting.repository.PostRepository;
import com.synerix.Joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
public class PostController {
    @Autowired
    PostRepository repo;
    @Autowired
    SearchRepository srepo;
    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    @PostMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return srepo.searchByText(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }
}
