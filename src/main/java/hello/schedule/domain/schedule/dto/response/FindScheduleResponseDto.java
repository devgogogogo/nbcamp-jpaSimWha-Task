package hello.schedule.domain.schedule.dto.response;

import lombok.Getter;

@Getter
public class FindScheduleResponseDto {
    private final Long id;
    private final String writerId;
    private final String title;
    private final String content;
    private final Long count;

    public FindScheduleResponseDto(Long id, String writerId, String title, String content, Long count) {
        this.id = id;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.count = count;
    }
}
