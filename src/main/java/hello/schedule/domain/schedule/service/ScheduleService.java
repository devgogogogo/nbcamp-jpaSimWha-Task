package hello.schedule.domain.schedule.service;

import hello.schedule.domain.schedule.dto.response.ScheduleResponseDto;

import java.util.List;

//서비스 인터페이스
public interface ScheduleService {
    ScheduleResponseDto createSchedule(String writerId, String title, String content);

    ScheduleResponseDto findById(Long id);

    List<ScheduleResponseDto> findAll();
}
