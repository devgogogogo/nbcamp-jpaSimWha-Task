package hello.schedule.domain.childComment.service;

import hello.schedule.domain.childComment.dto.response.ChildCommentResponseDto;
import hello.schedule.domain.childComment.dto.response.ParentCommentResponseDto;

import java.util.List;

public interface ChildCommentService {

    ChildCommentResponseDto createChildComment(Long commentId, String writerId, String childComment);

    ParentCommentResponseDto<ChildCommentResponseDto> findAll(Long commentId);


}
