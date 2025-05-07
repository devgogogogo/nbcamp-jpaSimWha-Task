package hello.schedule.common.response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessCode {

    //스케쥴
    SCHEDULE_CREATE_SUCCESS(201, HttpStatus.CREATED, "스케줄이 생성되었습니다."),
    SCHEDULE_GET_ONE_SUCCESS(200, HttpStatus.OK, "스케줄 단편 조회하였습니다."),
    SCHEDULE_GET_All_SUCCESS(200, HttpStatus.OK, "스케줄 전체를 조회하였습니다."),
    SCHEDULE_PUT_SUCCESS(200, HttpStatus.OK, "스케줄 수정을 성공하였습니다."),
    SCHEDULE_DELETE_SUCCESS(200, HttpStatus.OK, "스케줄를 삭제하였습니다."),

    //댓글
    COMMENT_CREATE_SUCCESS(201, HttpStatus.CREATED, "댓글이 생성되었습니다."),
    COMMENT_GET_ONE_SUCCESS(202, HttpStatus.OK, "댓글이 조회 되었습니다."),
    COMMENT_GET_ALL_SUCCESS(202, HttpStatus.OK, "전체 댓글이 조회 되었습니다."),
    COMMENT_PUT_SUCCESS(202, HttpStatus.OK, "댓글이 수정 되었습니다."),
    COMMENT_DELETE_SUCCESS(202, HttpStatus.OK, "댓글이 조회 삭제 되었습니다.");

    //대댓글


    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;

    SuccessCode(Integer code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
