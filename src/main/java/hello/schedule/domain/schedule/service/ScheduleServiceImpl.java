package hello.schedule.domain.schedule.service;

import hello.schedule.domain.schedule.dto.response.ScheduleResponseDto;
import hello.schedule.domain.schedule.entity.Schedule;
import hello.schedule.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;


    @Override // 스케쥴 생성
    public ScheduleResponseDto createSchedule(String writerId, String title, String content) {

        //엔티티에 넣어주고
        Schedule schedule = new Schedule(writerId, title, content);

        //DB에 넣어준다.
        Schedule savedSchedule = scheduleRepository.save(schedule);

        //다시 DB에 꺼내어서 responseDto로 넘겨준다.
        return new ScheduleResponseDto(savedSchedule.getWriterId(),savedSchedule.getTitle(),savedSchedule.getContent());
    }
}
