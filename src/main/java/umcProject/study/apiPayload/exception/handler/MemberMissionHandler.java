package umcProject.study.apiPayload.exception.handler;

import umcProject.study.apiPayload.code.BaseErrorCode;
import umcProject.study.apiPayload.exception.GeneralException;

public class MemberMissionHandler extends GeneralException {

    public MemberMissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
