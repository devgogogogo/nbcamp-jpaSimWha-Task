package hello.schedule.domain.comment.service;

import hello.schedule.domain.comment.dto.response.CommentResponseDto;

import java.util.List;

public interface CommentService {

    CommentResponseDto createComment(Long scheduleId, String writerId, String content);

    CommentResponseDto findById(Long commentId,Long scheduleId);

    List<CommentResponseDto> findAll(Long scheduleId);
}
