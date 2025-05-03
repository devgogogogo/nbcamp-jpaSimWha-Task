package hello.schedule.domain.comment.service;

import hello.schedule.domain.comment.dto.response.CommentResponseDto;

public interface CommentService {

    CommentResponseDto createComment(Long id, String writerId, String content);
}
