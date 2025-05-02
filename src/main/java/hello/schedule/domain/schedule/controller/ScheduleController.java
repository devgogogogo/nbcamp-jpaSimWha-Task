package hello.schedule.domain.schedule.controller;

import hello.schedule.common.response.ApiResponseDto;
import hello.schedule.common.response.SuccessCode;
import hello.schedule.domain.schedule.dto.request.ScheduleRequestDto;
import hello.schedule.domain.schedule.dto.response.ScheduleResponseDto;
import hello.schedule.domain.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping // 스케쥴 생성
    public ResponseEntity<ApiResponseDto<ScheduleResponseDto>> createSchedule(@RequestBody ScheduleRequestDto dto) {

        ScheduleResponseDto responseDto = scheduleService.createSchedule(dto.getWriterId(), dto.getTitle(), dto.getContent());

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.SCHEDULE_CREATE_SUCCESS, responseDto));
    }
}
