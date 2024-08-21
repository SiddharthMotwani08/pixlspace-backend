package com.fullstackproject.sid_pixlspace.service;

import com.fullstackproject.sid_pixlspace.entity.PostEntity;
import com.fullstackproject.sid_pixlspace.model.Post;
import com.fullstackproject.sid_pixlspace.repository.PostEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    private PostEntityRepository postEntityRepository;

    public PostServiceImpl(PostEntityRepository postEntityRepository) {
        this.postEntityRepository = postEntityRepository;
    }

    @Override
    public Post addPost(Post post) throws Exception {
        try {
            PostEntity postEntity = new PostEntity();
            BeanUtils.copyProperties(post, postEntity);

            if (post.getImage() != null && !post.getImage().equalsIgnoreCase("null")) {
                postEntity.setImage(post.getImage());
            }

            else {
                postEntity.setImage(null);
            }

            postEntity = postEntityRepository.save(postEntity);

            post.setId(postEntity.getId());
            post.setImage(post.getImage());
        }
        catch (Exception e) {
            throw new Exception("Could not post : " + e);
        }
        return post;
    }

    @Override
    public List<Post> getPost() {
        List<PostEntity> postEntities = postEntityRepository.findAll();

        List<Post> posts = new ArrayList<>();

        posts = postEntities.stream().map( postEntity -> Post.builder().id(postEntity.getId()).image(postEntity.getImage()).name(postEntity.getName()).post(postEntity.getPost()).timeStamp(postEntity.getTimeStamp()).profilePic(postEntity.getProfilePic()).build()).collect(Collectors.toList());

        return posts;
    }
}
