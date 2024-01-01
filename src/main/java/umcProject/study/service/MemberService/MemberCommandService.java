package umcProject.study.service.MemberService;

import umcProject.study.domain.Member;
import umcProject.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
     Member joinMember(MemberRequestDTO.JoinDTO request);
}
