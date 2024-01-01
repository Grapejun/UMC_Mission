package umcProject.study.web.dto;

import lombok.Getter;
import umcProject.study.domain.enums.MissionStatus;
import umcProject.study.validation.annotation.ExistMemberMission;

public class MemberMissionRequestDTO {

    @ExistMemberMission
    @Getter
    public static class ChallengeDTO {

        Long memberId;
        Long missionId;
        MissionStatus status;
    }
}
