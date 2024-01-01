package umcProject.study.apiPayload.exception.handler;

import umcProject.study.apiPayload.code.BaseErrorCode;
import umcProject.study.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
