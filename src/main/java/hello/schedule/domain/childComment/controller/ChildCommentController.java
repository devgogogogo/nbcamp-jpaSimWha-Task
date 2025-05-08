package hello.schedule.domain.childComment.controller;

import hello.schedule.common.response.ApiResponseDto;
import hello.schedule.common.response.SuccessCode;
import hello.schedule.domain.childComment.dto.request.ChildCommentRequestDto;
import hello.schedule.domain.childComment.dto.response.ChildCommentResponseDto;
import hello.schedule.domain.childComment.service.ChildCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules/{scheduleId}/comments/{commentId}/childComments")
@RequiredArgsConstructor
public class ChildCommentController {

    private final ChildCommentService childCommentService;

    @PostMapping //대댓글 생성
    public ResponseEntity<ApiResponseDto<ChildCommentResponseDto>> createChildComment(@PathVariable Long commentId, @RequestBody ChildCommentRequestDto dto) {

        //서비스 단으로 넘겨준다.
        ChildCommentResponseDto childCommentResponseDto = childCommentService.createChildComment(commentId, dto.getWriterId(), dto.getChildComment());

        //리턴을 공통api를 이용해서 responseDto로 반환한다.
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.CHILD_COMMENT_CREATE_SUCCESS,childCommentResponseDto));
    }
}
