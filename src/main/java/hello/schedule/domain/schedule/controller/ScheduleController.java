package hello.schedule.domain.schedule.controller;

import hello.schedule.common.response.ApiResponseDto;
import hello.schedule.common.response.SuccessCode;
import hello.schedule.domain.schedule.dto.request.ScheduleRequestDto;
import hello.schedule.domain.schedule.dto.response.ScheduleResponseDto;
import hello.schedule.domain.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping // 스케쥴 생성
    public ResponseEntity<ApiResponseDto<ScheduleResponseDto>> createSchedule(@RequestBody ScheduleRequestDto dto) {

        //서비스로 넘겨주고
        ScheduleResponseDto responseDto = scheduleService.createSchedule(dto.getWriterId(), dto.getTitle(), dto.getContent());

        //리턴은 스케줄응답으로 반환한다.
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.SCHEDULE_CREATE_SUCCESS, responseDto));
    }

    @GetMapping("/{id}") // //스케줄 단편 조회
    public ResponseEntity<ApiResponseDto<ScheduleResponseDto>> findById(@PathVariable Long id) {

        //서비스 단으로 넘겨준다.
        ScheduleResponseDto findById = scheduleService.findById(id);

        //공통응답으로 리턴해준다.
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.SCHEDULE_GET_ONE_SUCCESS, findById));
    }
}
