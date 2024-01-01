package umcProject.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umcProject.study.validation.validator.CategoryExistValidator;
import umcProject.study.validation.validator.MemberMissionExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberMissionExistValidator.class)
@Target( {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMemberMission {

    String message() default "이미 도전 중인 미션 입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
