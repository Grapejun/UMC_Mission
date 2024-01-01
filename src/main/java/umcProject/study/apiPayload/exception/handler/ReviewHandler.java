package umcProject.study.apiPayload.exception.handler;

import umcProject.study.apiPayload.code.BaseErrorCode;
import umcProject.study.apiPayload.exception.GeneralException;

public class ReviewHandler extends GeneralException {

    public ReviewHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
