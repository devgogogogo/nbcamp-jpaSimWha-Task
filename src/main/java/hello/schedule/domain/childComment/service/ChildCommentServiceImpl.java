package hello.schedule.domain.childComment.service;

import hello.schedule.domain.childComment.dto.response.ChildCommentResponseDto;
import hello.schedule.domain.childComment.entity.ChildComment;
import hello.schedule.domain.childComment.repository.ChildCommentRepository;
import hello.schedule.domain.comment.entity.Comment;
import hello.schedule.domain.comment.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ChildCommentServiceImpl implements ChildCommentService {

    private final ChildCommentRepository childCommentRepository;
    private final CommentRepository commentRepository;


    @Transactional
    @Override
    public ChildCommentResponseDto createChildComment(Long commentId, String writerId, String childComment) {

        //댓글 객체를 가져온다 (있는지 없는지 확인한다. 없으면 예외처리)
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


        //대댓글 객체를 생성한다.
        ChildComment childCommentEntity = new ChildComment(writerId, childComment, comment);

        //DB에 넣어준다.
        ChildComment savedChildComment = childCommentRepository.save(childCommentEntity);

        //ResponseDto로 반환한다.
        return new ChildCommentResponseDto(savedChildComment.getId(),savedChildComment.getWriterId(),savedChildComment.getChildComment(),savedChildComment.getUpdatedAt());
    }
}
