package hello.schedule.domain.schedule.service;

import hello.schedule.domain.schedule.dto.response.FindScheduleResponseDto;
import hello.schedule.domain.schedule.dto.response.ScheduleResponseDto;
import hello.schedule.domain.schedule.dto.response.UpdateScheduleResponseDto;

import java.util.List;

//서비스 인터페이스
public interface ScheduleService {

    //스케줄 생성
    ScheduleResponseDto createSchedule(String writerId, String title, String content);

    //스케줄 단일 조회
    ScheduleResponseDto findById(Long id);

    //스케줄 전체 조회
    List<FindScheduleResponseDto> findAll();

    //스케줄 삭제
    void deleteSchedule(Long id);

    //스케줄 수정
    UpdateScheduleResponseDto updateSchedule(Long id, String title, String content);
}
