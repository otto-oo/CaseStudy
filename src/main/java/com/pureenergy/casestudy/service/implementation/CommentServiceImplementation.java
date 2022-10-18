package com.pureenergy.casestudy.service.implementation;

import com.pureenergy.casestudy.dto.CommentDTO;
import com.pureenergy.casestudy.entity.Comment;
import com.pureenergy.casestudy.enums.Operation;
import com.pureenergy.casestudy.exception.NoSuchMovieException;
import com.pureenergy.casestudy.repository.CommentRepository;
import com.pureenergy.casestudy.repository.MovieRepository;
import com.pureenergy.casestudy.service.CommentService;
import com.pureenergy.casestudy.util.LogUtil;
import com.pureenergy.casestudy.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommentServiceImplementation implements CommentService {

    private CommentRepository commentRepository;
    private MapperUtil mapperUtil;
    private LogUtil logUtil;
    private MovieRepository movieRepository;

    public CommentServiceImplementation(CommentRepository commentRepository, MapperUtil mapperUtil, LogUtil logUtil, MovieRepository movieRepository) {
        this.commentRepository = commentRepository;
        this.mapperUtil = mapperUtil;
        this.logUtil = logUtil;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<CommentDTO> getCommentsByMovieId(Long movieId) {
        if (!movieRepository.findById(movieId).isPresent()){
            throw new NoSuchMovieException(movieId);
        }
        List<Comment> commentList = commentRepository.findByMovieId(movieId);
        log.info("Comments are getting by movie id " + movieId);
        logUtil.createLog(Operation.READ, "Comments are getting by movie id " + movieId);
        return commentList
                .stream()
                .map(comment -> mapperUtil.convert(comment, new CommentDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) {
        if (!movieRepository.findById(commentDTO.getMovieId()).isPresent()){
            throw new NoSuchMovieException(commentDTO.getMovieId());
        }
        log.info("Comment is created.");
        logUtil.createLog(Operation.CREATE, "Comment is created.");
        Comment comment = mapperUtil.convert(commentDTO, new Comment());
        commentRepository.save(comment);
        return commentDTO;
    }


}
