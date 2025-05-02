package hello.schedule.domain.schedule.service;

import hello.schedule.domain.schedule.dto.response.ScheduleResponseDto;

//서비스 인터페이스
public interface ScheduleService {
    ScheduleResponseDto createSchedule(String writerId, String title, String content);
}
