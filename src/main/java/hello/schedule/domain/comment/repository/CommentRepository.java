package hello.schedule.domain.comment.repository;

import hello.schedule.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
     List<Comment> findByScheduleId(Long scheduleId);

     Optional<Comment> findByScheduleIdAndId(Long scheduleId, Long id);

     Long countByScheduleId(Long scheduleId);
}
