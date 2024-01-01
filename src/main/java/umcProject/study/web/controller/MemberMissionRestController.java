package umcProject.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcProject.study.apiPayload.ApiResponse;
import umcProject.study.converter.MemberMissionConverter;
import umcProject.study.domain.mapping.MemberMission;
import umcProject.study.service.MemberMissionService.MemberMissionCommandService;
import umcProject.study.web.dto.MemberMissionRequestDTO;
import umcProject.study.web.dto.MemberMissionResponseDTO;
import umcProject.study.web.dto.MemberRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memberMissions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.ChallengeResultDTO> challenge(@RequestBody @Valid MemberMissionRequestDTO.ChallengeDTO request) {
        MemberMission memberMission = memberMissionCommandService.challengeMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeResultDTO(memberMission));
    }
}
