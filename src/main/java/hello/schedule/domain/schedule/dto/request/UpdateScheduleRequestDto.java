package hello.schedule.domain.schedule.dto.request;

import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {

    private final String title;
    private final String content;

    public UpdateScheduleRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
