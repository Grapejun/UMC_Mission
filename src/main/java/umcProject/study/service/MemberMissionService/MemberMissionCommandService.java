package umcProject.study.service.MemberMissionService;

import umcProject.study.domain.mapping.MemberMission;
import umcProject.study.web.dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    public MemberMission challengeMission(MemberMissionRequestDTO.ChallengeDTO request);
}
