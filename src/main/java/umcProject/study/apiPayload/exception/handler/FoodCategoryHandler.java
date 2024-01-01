package umcProject.study.apiPayload.exception.handler;

import umcProject.study.apiPayload.code.BaseErrorCode;
import umcProject.study.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
