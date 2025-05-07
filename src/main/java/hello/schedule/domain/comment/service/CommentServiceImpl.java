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
    @Override //해당 스케줄에 대한 댓글 단일 조회
    public CommentResponseDto findById(Long commentId, Long scheduleId) {

        Comment findComment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("조회할 댓글이 없습니다."));
        Long findScheduleId = findComment.getSchedule().getId();

        //findScheduleId == 요청하는 scheduleId 와 같은지 확인한다.
        if (!findScheduleId.equals(scheduleId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"댓글이 없습니다.");
        }
        Schedule findSchedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new IllegalArgumentException("조회할 댓글이 없습니다"));


        //끄집어낸 댓글 객체를 responseDto에 넣어준다.
        return new CommentResponseDto(findComment.getId(), findComment.getWriterId(), findComment.getContent(), LocalDateTime.now());
    }

    @Transactional
    @Override //해당 스케줄 댓글 전체 조회
    public List<CommentResponseDto> findAll(Long scheduleId) {


        List<Comment> findByScheduleId = commentRepository.findByScheduleId(scheduleId);

        List<CommentResponseDto> list = findByScheduleId
                .stream()
                .map(m -> new CommentResponseDto(m.getId(), m.getWriterId(), m.getContent(), LocalDateTime.now()))
                .toList();


        return list;
    }

    @Transactional
    @Override //해당 스케줄 댓글 수정
    public CommentResponseDto updateComment(Long commentId, Long scheduleId, String writerId, String content) {

        //댓글을 찾고
        Comment findComment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("수정할 댓글이 없습니다"));

        //그 댓글의 기본키를 찾아온다음
        Long findCommentId = findComment.getSchedule().getId();

        //요청하는 scheduleId와 같은지 비교한다.
        if (!findCommentId.equals(scheduleId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정할 댓글이 없습니다.");
        }

        //엔티티에 만들어둔 메서드를 사용하고.
        findComment.update(writerId, content);

        // responseDto에 넣어 반환한다.
        return new CommentResponseDto(findComment.getId(), findComment.getWriterId(), findComment.getContent(), LocalDateTime.now());
    }
}
