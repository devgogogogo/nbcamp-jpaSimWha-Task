package hello.schedule.domain.childComment.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ChildCommentResponseDto {

    private final Long id;
    private final String writerId;
    private final String childComment;
    private final LocalDateTime lastModifiedDate;

    public ChildCommentResponseDto(Long id, String writerId, String childComment, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.writerId = writerId;
        this.childComment = childComment;
        this.lastModifiedDate = lastModifiedDate;
    }
}
