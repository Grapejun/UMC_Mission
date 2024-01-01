package umcProject.study.converter;

import umcProject.study.domain.Mission;
import umcProject.study.web.dto.MissionAddResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionAddResponseDTO.AddResultDTO toAddResultDTO(Mission mission) {
        return MissionAddResponseDTO.AddResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
