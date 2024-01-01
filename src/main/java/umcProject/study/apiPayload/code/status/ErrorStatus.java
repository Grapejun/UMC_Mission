package umcProject.study.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umcProject.study.apiPayload.code.BaseErrorCode;
import umcProject.study.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // For test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

    //Food_category 관련 에러
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD_CATEGORY4001", "음식 카테고리를 찾을 수 없습니다."),

    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION4001", "지역을 찾을 수 없습니다."),

    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE4001", "식당을 찾을 수 없습니다."),

    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION4001", "미션을 찾을 수 없습니다."),


    DUPLICATED_MEMBER_MISSION(HttpStatus.BAD_REQUEST, "MEMBERMISSION4001", "중복된 미션 등록입니다."),

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러. 관리자에게 문의 바랍니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // Member Error
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // Article Error
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다.")
    ;


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() { //getReason + getHttpStatus
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
