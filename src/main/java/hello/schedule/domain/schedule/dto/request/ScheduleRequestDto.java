package hello.schedule.domain.schedule.dto.request;


import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private final String writerId;
    private final String title;
    private final String content;

    public ScheduleRequestDto(String writerId, String title, String content) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
    }
}
