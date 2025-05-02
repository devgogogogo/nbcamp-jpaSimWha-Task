package hello.schedule.common.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.time.LocalDateTime;

@JsonPropertyOrder({ "timestamp","code","data", "message"})
// 저 필드 순서대로 응답처리가 나온다.
@Getter
public class ApiResponseDto<T> {

    private LocalDateTime timestamp;
    private T data;
    private String message;

    public ApiResponseDto(SuccessCode successCode, T data) {
        this.timestamp = LocalDateTime.now();
        this.data = data;
        this.message = successCode.getMessage();
    }

    //공통 응답 처리
    public static <T> ApiResponseDto<T> success(SuccessCode successCode, T data) {

        return new ApiResponseDto<T>(successCode, data);
    }
}
