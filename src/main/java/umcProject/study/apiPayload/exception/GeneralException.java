package umcProject.study.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umcProject.study.apiPayload.code.BaseErrorCode;
import umcProject.study.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
