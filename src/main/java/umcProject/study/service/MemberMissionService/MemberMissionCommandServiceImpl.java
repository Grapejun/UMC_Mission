package umcProject.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcProject.study.apiPayload.code.status.ErrorStatus;
import umcProject.study.apiPayload.exception.handler.FoodCategoryHandler;
import umcProject.study.apiPayload.exception.handler.MemberMissionHandler;
import umcProject.study.converter.MemberMissionConverter;
import umcProject.study.domain.Member;
import umcProject.study.domain.Mission;
import umcProject.study.domain.mapping.MemberMission;
import umcProject.study.repository.MemberMissionRepository;
import umcProject.study.repository.MemberRepository;
import umcProject.study.repository.MissionRepository;
import umcProject.study.web.dto.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public MemberMission challengeMission(MemberMissionRequestDTO.ChallengeDTO request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        // 도전 하려는 미션이 이미 도전 중인지를 검증해야 하며 이를 커스텀 어노테이션을 통해 검증을 해야 함.

        MemberMission newMemberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(request.getStatus())
                .build();


        member.setMemberMissionList(newMemberMission);

        return memberMissionRepository.save(newMemberMission);
    }
}
//RuntimeException -> 핸들러에서 처리하도록 바꾸기 - OK
// 에러 핸들러 & Validation 돌아가는 꼴 파악하기
