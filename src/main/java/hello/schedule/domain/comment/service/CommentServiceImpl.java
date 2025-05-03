package hello.schedule.domain.comment.service;

import hello.schedule.domain.comment.dto.response.CommentResponseDto;
import hello.schedule.domain.comment.entity.Comment;
import hello.schedule.domain.comment.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    @Override
    public CommentResponseDto createComment(Long id, String writerId, String content) {

        //객체에 집어 넣고
        Comment comment = new Comment(writerId, content);

        //그 객체를 DB에 넣어준다.
        Comment savedComment = commentRepository.save(comment);

        //다시 DB에 꺼내어서 responseDto로 넘겨준다.
        return new CommentResponseDto(savedComment.getId(), savedComment.getWriterId(), savedComment.getContent(), LocalDateTime.now());
    }
}
