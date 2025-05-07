package hello.schedule.domain.comment.service;

import hello.schedule.domain.comment.dto.response.CommentResponseDto;
import hello.schedule.domain.comment.entity.Comment;
import hello.schedule.domain.comment.repository.CommentRepository;
import hello.schedule.domain.schedule.entity.Schedule;
import hello.schedule.domain.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository; // scheduleRepository를 추가해줘햐 한다.
    //Comment 엔티티는 Schedule 객체와 연관되므로, Comment 생성 시 관련된 Schedule 객체를 함께 설정해야 합니다.
    // 이를 구현하려면 CommentServiceImpl 클래스에서 Schedule 객체를 먼저 조회한 뒤에 Comment를 생성하는 방식으로 수정하면 된다.

    @Transactional
    @Override
    public CommentResponseDto createComment(Long id, String writerId, String content) {

        //스케줄 엔티티 조회하고(스케줄 객체를 하나 생성해준다. --> 댓글 객체에 넣어줘야 하기 때문에)
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 스케줄이 존재하지 않습니다"));


        //댓글객체 생성할때 스케줄을 주입함
        Comment comment = new Comment(writerId, content, schedule);

        //그 객체를 DB에 넣어준다.
        Comment savedComment = commentRepository.save(comment);

        //다시 DB에 꺼내어서 responseDto로 넘겨준다.
        return new CommentResponseDto(savedComment.getId(), savedComment.getWriterId(), savedComment.getContent(), LocalDateTime.now());
    }

    @Transactional
    @Override //해당 댓글 단일 조회
    public CommentResponseDto findById(Long commentId, Long scheduleId) {

//        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new IllegalArgumentException("일정이 존재 하지 않습니다."));

//        Long findScheduleId = schedule.getId();
        //댓글 객체 써낸다 (있는지 확인해보고 없으면 예외처리 ㄱㄱ)

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("조회할 댓글이 없습니다."));
        Long findCommentId = comment.getSchedule().getId();

        // findScheduleID와 요청하는 scheduleId 와 같다.
        if (findCommentId.equals(scheduleId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"댓글이 없습니다.");
        }

        //끄집어낸 댓글 객체를 responseDto에 넣어준다.
        return new CommentResponseDto(comment.getId(), comment.getWriterId(), comment.getContent(), LocalDateTime.now());
    }

    @Transactional
    @Override
    public List<CommentResponseDto> findAll(Long scheduleId) {

        List<Comment> findAllComment = commentRepository.findAll();

        //원초적인 방법
//        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
//        for (Comment comment : findAllComment) {
//            CommentResponseDto commentResponseDto = new CommentResponseDto(comment.getId(), comment.getWriterId(), comment.getContent(), LocalDateTime.now());
//            commentResponseDtoList.add(commentResponseDto);
//        }

        //향상된?방법
        List<CommentResponseDto> list = findAllComment.stream()
                .map(m -> new CommentResponseDto(m.getId(), m.getWriterId(), m.getContent(), LocalDateTime.now()))
                .toList();

        return list;
    }


}
