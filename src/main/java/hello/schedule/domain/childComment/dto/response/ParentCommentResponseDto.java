package hello.schedule.domain.childComment.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class ParentCommentResponseDto<T>{

    private final Long id;
    private final String content;
    private final List<T> childComment;


    public ParentCommentResponseDto(Long id, String content, List<T> childComment) {
        this.id = id;
        this.content = content;
        this.childComment = childComment;
    }
}
