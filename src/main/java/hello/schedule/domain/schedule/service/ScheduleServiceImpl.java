package hello.schedule.domain.schedule.service;

import hello.schedule.domain.schedule.dto.response.ScheduleResponseDto;
import hello.schedule.domain.schedule.dto.response.UpdateScheduleResponseDto;
import hello.schedule.domain.schedule.entity.Schedule;
import hello.schedule.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override //스케줄 전체 조회
    public List<ScheduleResponseDto> findAll() {

        //DB에 findAll을 해서 List<Schedule> 을 가지고 나온다.
        List<Schedule> findAll = scheduleRepository.findAll();

        //담아갈 배열을 하나 만들어 준다.
        List<ScheduleResponseDto> scheduleResponseDtoList = new ArrayList<>();

        //for문으로 responseDto에 넣어준다.
        for (Schedule schedule : findAll) {
            ScheduleResponseDto findSchedule = new ScheduleResponseDto(schedule.getId(), schedule.getWriterId(), schedule.getTitle(), schedule.getContent());
            scheduleResponseDtoList.add(findSchedule);
        }

        //for문으로 넣어준 responseDto를 반환한다.
        return scheduleResponseDtoList;
    }

    @Override // 스케줄 수정
    public UpdateScheduleResponseDto updateSchedule(Long id, String title, String content) {

        //스케줄이 있는지 확인해본다 -->없으면 ?--> 예외처리 ㄱㄱ
        Schedule findById = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("수정할 스케줄이 없습니다."));

        //있다면 업데이트하자 (스케줄 엔티티에 메서드 만들어놨음)
        findById.update(title, content);

        //dto로 넣어서 반환한다.
        return new UpdateScheduleResponseDto(findById.getId(),findById.getWriterId(),findById.getTitle(),findById.getContent());
    }

    @Override //스케줄 삭제
    public void deleteSchedule(Long id) {
        // 일단 스케줄이 있는지 확인한다.
        Schedule findById = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("삭제할 스케줄이 없습니다."));

        //있으면 삭제 ㄱㄱ
        scheduleRepository.delete(findById);
    }
}
