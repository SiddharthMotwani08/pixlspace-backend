package com.fullstackproject.sid_pixlspace.repository;

import com.fullstackproject.sid_pixlspace.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity, String> {

}
