package umcProject.study.service.MissionService;

import umcProject.study.domain.Mission;
import umcProject.study.web.dto.MissionAddRequestDTO;

public interface MissionCommandService {

    public Mission AddMission(MissionAddRequestDTO.AddDTO request);

}


