package umcProject.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcProject.study.apiPayload.ApiResponse;
import umcProject.study.converter.MissionConverter;
import umcProject.study.domain.Mission;
import umcProject.study.service.MissionService.MissionCommandService;
import umcProject.study.web.dto.MissionAddRequestDTO;
import umcProject.study.web.dto.MissionAddResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionAddResponseDTO.AddResultDTO> Add(@RequestBody @Valid MissionAddRequestDTO.AddDTO request) {
        Mission mission = missionCommandService.AddMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }
}
