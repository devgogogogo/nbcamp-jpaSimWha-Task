package hello.schedule.domain.childComment.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ChildCommentResponseDto {

    private final Long id;
    private final String writerId;
    private final String childComment;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final LocalDateTime updateAt;

    public ChildCommentResponseDto(Long id, String writerId, String childComment, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.writerId = writerId;
        this.childComment = childComment;
        this.updateAt = lastModifiedDate;
    }
}
