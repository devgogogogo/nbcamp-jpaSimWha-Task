package hello.schedule.domain.comment.controller;

import hello.schedule.common.response.ApiResponseDto;
import hello.schedule.common.response.SuccessCode;
import hello.schedule.domain.comment.dto.request.CommentRequestDto;
import hello.schedule.domain.comment.dto.response.CommentResponseDto;
import hello.schedule.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules/{id}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService; //생성자 주입

    @PostMapping
    public ResponseEntity<ApiResponseDto<CommentResponseDto>> createComment(@PathVariable Long id, @RequestBody CommentRequestDto dto) {

        //서비스단으로 넘겨준다.
        CommentResponseDto commentResponseDto = commentService.createComment(id,dto.getWriterId(),dto.getContent());

        //리턴을 공통api를 이용해서 responseDto로 반환한다.
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.COMMENT_CREATE_SUCCESS, commentResponseDto));
    }
}
