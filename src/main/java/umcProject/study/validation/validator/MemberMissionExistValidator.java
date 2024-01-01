package umcProject.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umcProject.study.apiPayload.code.status.ErrorStatus;
import umcProject.study.apiPayload.exception.MemberMissionAlreadyExistsException;
import umcProject.study.repository.MemberMissionRepository;
import umcProject.study.validation.annotation.ExistMemberMission;
import umcProject.study.web.dto.MemberMissionRequestDTO;

@Component
@RequiredArgsConstructor
public class MemberMissionExistValidator implements ConstraintValidator<ExistMemberMission, MemberMissionRequestDTO.ChallengeDTO> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(ExistMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO.ChallengeDTO challengeDTO, ConstraintValidatorContext context) {
        if (challengeDTO == null) {
            return true; // null 값 처리 로직에 따라 true 또는 false
        }

        Long memberId = challengeDTO.getMemberId();
        Long missionId = challengeDTO.getMissionId();

        // Check if a MemberMission with the same memberId and missionId already exists
        boolean exists = memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);

        if (exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("이미 진행 중인 미션 입니다.")
                    .addConstraintViolation();
            return false; // 중복이 발견되면 유효하지 않음
        }

        return true;
    }



    /*@Override
    public boolean isValid(MemberMissionRequestDTO.ChallengeDTO challengeDTO, ConstraintValidatorContext context) {
        if (challengeDTO == null) {
            return true; // null 값 처리 로직에 따라 true 또는 false
        }

        Long memberId = challengeDTO.getMemberId();
        Long missionId = challengeDTO.getMissionId();

        // Check if a MemberMission with the same memberId and missionId already exists
        boolean exists = memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);

        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.DUPLICATED_MEMBER_MISSION.getMessage()).addConstraintViolation();
        }

        return !exists; // 이미 존재하는 경우 false 반환
    }*/
}
