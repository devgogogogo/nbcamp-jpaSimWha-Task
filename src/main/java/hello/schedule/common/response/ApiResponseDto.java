package hello.schedule.common.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonPropertyOrder({ "timestamp","code","data", "message"})
// 저 필드 순서대로 응답처리가 나온다.
@Getter
public class ApiResponseDto<T> {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final LocalDateTime timestamp;

    @JsonInclude(value = NON_NULL)  // 실제 응답 데이터 (nullable), null이면 JSON에서 제외됨
    private final T data; // 응답 Dto

    private final String message; //Enum에 있는 메세지


    public ApiResponseDto(SuccessCode successCode, T data) {
        this.timestamp = LocalDateTime.now();
        this.data = data;
        this.message = successCode.getMessage();
    }

    //공통 응답 처리
    public static <T> ApiResponseDto<T> success(SuccessCode successCode, T data) {

        return new ApiResponseDto<>(successCode, data);
    }
}
