package com.fullstackproject.sid_pixlspace.controller;

import com.fullstackproject.sid_pixlspace.model.Post;
import com.fullstackproject.sid_pixlspace.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/post")
@CrossOrigin(value = "http://localhost:3000")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post addPost(@RequestParam Map<String, String> requestParams) throws Exception {
        String poststr = requestParams.get("post");
        String name = requestParams.get("name");
        String profilePic = requestParams.get("profilePic");
        String image = requestParams.get("image");

        Post post = Post.builder()
                .post(poststr)
                .profilePic(profilePic)
                .name(name)
                .image(image)
                .timeStamp(new Date().toString())
                .build();

        post = postService.addPost(post);
        return post;
    }

    @GetMapping
    public List<Post> getPost() {
        return postService.getPost();
    }
}
