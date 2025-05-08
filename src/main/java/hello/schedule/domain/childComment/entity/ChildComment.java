package hello.schedule.domain.childComment.entity;

import hello.schedule.common.baseEntity.BaseEntity;
import hello.schedule.domain.comment.entity.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "childcomment")
public class ChildComment extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String writerId;

    @Column(nullable = false)
    private String childComment;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public ChildComment(String writerId, String childComment, Comment comment) {
        this.writerId = writerId;
        this.childComment = childComment;
        this.comment = comment;
    }
}
