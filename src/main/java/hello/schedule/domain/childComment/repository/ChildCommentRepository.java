package hello.schedule.domain.childComment.repository;

import hello.schedule.domain.childComment.entity.ChildComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildCommentRepository extends JpaRepository<ChildComment, Long> {

    List<ChildComment> findByCommentId(Long commentId);



}
