package umcProject.study.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor //@NoArgsConstructor은 fianl이 붙은 멤버변수가 있다면 사용할 수 없다.
public class ErrorReasonDTO {

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    private final boolean isSuccess; // isSuccess 필드 추가


    /*public static class Builder { // @Builder 가 자동 생성 해줌
        private HttpStatus httpStatus;
        private String code;
        private String message;
        private boolean isSuccess; // Builder 내부에 isSuccess 필드 추가
        
        public Builder HttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder isSuccess(boolean isSuccess) { // isSuccess 설정 메소드 추가
            this.isSuccess = isSuccess;
            return this;
        }

    }*/
}
