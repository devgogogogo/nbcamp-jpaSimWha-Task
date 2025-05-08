package hello.schedule.domain.childComment.repository;

import hello.schedule.domain.childComment.entity.ChildComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildCommentRepository extends JpaRepository<ChildComment, Long> {
}
