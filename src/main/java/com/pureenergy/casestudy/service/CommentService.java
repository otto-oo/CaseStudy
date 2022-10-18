package com.pureenergy.casestudy.service;

import com.pureenergy.casestudy.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> getCommentsByMovieId(Long movieId);

    CommentDTO createComment(CommentDTO commentDTO);
}
