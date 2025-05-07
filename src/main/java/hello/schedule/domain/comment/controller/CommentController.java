package hello.schedule.domain.comment.controller;

import hello.schedule.common.response.ApiResponseDto;
import hello.schedule.common.response.SuccessCode;
import hello.schedule.domain.comment.dto.request.CommentRequestDto;
import hello.schedule.domain.comment.dto.response.CommentResponseDto;
import hello.schedule.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules/{scheduleId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService; //생성자 주입

    @PostMapping
    public ResponseEntity<ApiResponseDto<CommentResponseDto>> createComment(@PathVariable Long scheduleId, @RequestBody CommentRequestDto dto) {

        //서비스단으로 넘겨준다.
        CommentResponseDto commentResponseDto = commentService.createComment(scheduleId, dto.getWriterId(), dto.getContent());

        //리턴을 공통api를 이용해서 responseDto로 반환한다.
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.COMMENT_CREATE_SUCCESS, commentResponseDto));
    }

    @GetMapping("/{commentId}") //댓글 단일 조회
    public ResponseEntity<ApiResponseDto<CommentResponseDto>> findById(@PathVariable Long commentId, @PathVariable Long scheduleId) {

        //서비스 단으로 넘겨준다.
        CommentResponseDto findById = commentService.findById(commentId, scheduleId);

        //리턴을 공통api를 이용해서 responseDto로 반환한다.
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.COMMENT_GET_ONE_SUCCESS, findById));
    }

    @GetMapping()// 댓글 전체 전회
    public ResponseEntity<ApiResponseDto<List<CommentResponseDto>>> findAll(@PathVariable Long scheduleId) {

        //서비스 단으로 넘겨준다.
        List<CommentResponseDto> findAllCommentList = commentService.findAll(scheduleId);

        //리턴을 공통api를 이용해서 responseDto로 반환한다.
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.COMMENT_GET_ALL_SUCCESS, findAllCommentList));
    }

    @PutMapping("/{commentId}") //댓글 수정
    public ResponseEntity<ApiResponseDto<CommentResponseDto>> updateComment(@PathVariable Long commentId, @PathVariable Long scheduleId, @RequestBody CommentRequestDto dto) {

        //서비스 단으로 넘겨준다.
        CommentResponseDto commentResponseDto = commentService.updateComment(commentId, scheduleId, dto.getWriterId(), dto.getContent());

        //리턴을 공통api를 이용해서 responseDto로 반환한다.
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.COMMENT_PUT_SUCCESS, commentResponseDto));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponseDto<Void>> deleteComment(@PathVariable Long commentId, @PathVariable Long scheduleId) {

        commentService.delete(commentId,scheduleId);

        return ResponseEntity.noContent().build();
    }
}
