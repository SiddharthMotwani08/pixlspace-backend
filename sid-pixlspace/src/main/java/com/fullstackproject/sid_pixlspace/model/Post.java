package com.fullstackproject.sid_pixlspace.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collector;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    private String id;
    private String post;
    private String image;
    private String profilePic;
    private String name;
    private String timeStamp;
    private String file;

}