package hello.schedule.domain.comment.dto.request;

import lombok.Getter;

@Getter
public class CommentRequestDto {

    private final String writerId;
    private final String content;


    public CommentRequestDto(String writerId, String content) {
        this.writerId = writerId;
        this.content = content;
    }
}
