package umcProject.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcProject.study.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}
