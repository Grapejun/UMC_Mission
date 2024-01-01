package umcProject.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umcProject.study.apiPayload.code.status.ErrorStatus;
import umcProject.study.apiPayload.exception.handler.ReviewHandler;
import umcProject.study.domain.Mission;
import umcProject.study.domain.Store;
import umcProject.study.repository.MissionRepository;
import umcProject.study.repository.StoreRepository;
import umcProject.study.web.dto.MissionAddRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Mission AddMission(MissionAddRequestDTO.AddDTO request) {

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new ReviewHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission newMission = Mission.builder()
                .reward(request.getReward())
                .missionSpec(request.getMissionSpec())
                .deadline(request.getDeadline())
                .store(store)
                .build();

        store.setMission(newMission);

        return missionRepository.save(newMission);
    }
}
