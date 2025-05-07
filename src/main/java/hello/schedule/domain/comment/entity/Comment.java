package hello.schedule.domain.comment.entity;

import hello.schedule.common.baseEntity.BaseEntity;
import hello.schedule.domain.schedule.entity.Schedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String writerId;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(String writerId, String content, Schedule schedule) {
        this.writerId = writerId;
        this.content = content;
        this.schedule = schedule;
    }

    // 댓글 업데이트 메서드

    public void update(String writerId, String content) {
        this.writerId = writerId;
        this.content = content;
    }
}
