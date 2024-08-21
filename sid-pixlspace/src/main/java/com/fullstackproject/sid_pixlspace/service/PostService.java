package com.fullstackproject.sid_pixlspace.service;

import com.fullstackproject.sid_pixlspace.model.Post;

import java.util.List;

public interface PostService {
    Post addPost(Post post) throws Exception;

    List<Post> getPost();
}
