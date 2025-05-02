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
        return new ScheduleResponseDto(savedSchedule.getId(),savedSchedule.getWriterId(),savedSchedule.getTitle(),savedSchedule.getContent());
    }

    @Override //스케줄 단편 조회
    public ScheduleResponseDto findById(Long id) {

        //식별자로 스케쥴을 조회한다. --> 없으면 예외처리
        Schedule findById = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("조회할 스케쥴이 없습니다."));

        //스케줄 객체를 responseDto에 넣어준다.
        return new ScheduleResponseDto(findById.getId(),findById.getWriterId(),findById.getTitle(),findById.getContent());
    }
}
