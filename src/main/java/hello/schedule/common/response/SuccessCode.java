package hello.schedule.common.response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessCode {

    SCHEDULE_CREATE_SUCCESS(201, HttpStatus.CREATED, "스케쥴이 생성되었습니다."),
    SCHEDULE_GET_ONE_SUCCESS(200, HttpStatus.OK, "스케쥴 단편 조회하였습니다."),
    SCHEDULE_GET_All_SUCCESS(200, HttpStatus.OK, "스케쥴 전체를 조회하였습니다.");



    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;

    SuccessCode(Integer code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
    }
