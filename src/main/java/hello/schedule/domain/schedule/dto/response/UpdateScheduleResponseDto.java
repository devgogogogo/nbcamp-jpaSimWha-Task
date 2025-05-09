package hello.schedule.domain.schedule.dto.response;

import lombok.Getter;

@Getter
public class UpdateScheduleResponseDto {

    private final Long id;
    private final String writerId;
    private final String title;
    private final String content;

    public UpdateScheduleResponseDto(Long id, String writerId, String title, String content) {
        this.id = id;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
    }
}
