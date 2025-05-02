package hello.schedule.domain.schedule.entity;

import hello.schedule.common.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "schedule")
@Entity
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String writerId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public Schedule(String writerId, String title, String content) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
    }

    //업데이트 메서드
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
