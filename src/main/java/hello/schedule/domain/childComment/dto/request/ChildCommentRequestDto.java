package hello.schedule.domain.childComment.dto.request;

import lombok.Getter;

@Getter
public class ChildCommentRequestDto {

    private final String writerId;
    private final String childComment;

    public ChildCommentRequestDto(String writerId, String childComment) {
        this.writerId = writerId;
        this.childComment = childComment;
    }
}
