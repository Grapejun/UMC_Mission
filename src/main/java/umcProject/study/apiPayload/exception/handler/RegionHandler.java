package umcProject.study.apiPayload.exception.handler;

import umcProject.study.apiPayload.code.BaseErrorCode;
import umcProject.study.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
