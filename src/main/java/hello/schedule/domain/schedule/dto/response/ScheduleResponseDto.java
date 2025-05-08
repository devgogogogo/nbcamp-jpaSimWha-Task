package hello.schedule.domain.schedule.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String writerId;
    private final String title;
    private final String content;



    public ScheduleResponseDto(Long id, String writerId, String title, String content) {
        this.id = id;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
    }
}
