package hello.schedule.domain.comment.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

    private final Long id;

    private final String writerId;

    private final String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime updateAt;


    //생성자
    @Builder
    public CommentResponseDto(Long id, String writerId, String content, LocalDateTime updateAt) {
        this.id = id;
        this.writerId = writerId;
        this.content = content;
        this.updateAt = updateAt;
    }
}
