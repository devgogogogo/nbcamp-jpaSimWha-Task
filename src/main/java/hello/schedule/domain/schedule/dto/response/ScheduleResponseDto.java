package hello.schedule.domain.schedule.dto.response;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final String writerId;
    private final String title;
    private final String content;

    public ScheduleResponseDto(String writerId, String title, String content) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
    }
}
