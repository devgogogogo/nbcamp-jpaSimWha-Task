package hello.schedule.domain.childComment.service;

import hello.schedule.domain.childComment.dto.response.ChildCommentResponseDto;

public interface ChildCommentService {

    ChildCommentResponseDto createChildComment(Long commentId, String writerId, String childComment);
}
