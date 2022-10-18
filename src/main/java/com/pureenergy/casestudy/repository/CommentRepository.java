package com.pureenergy.casestudy.repository;

import com.pureenergy.casestudy.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByMovieId(Long movieId);
}
