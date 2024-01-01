package umcProject.study.service.StoreService;

import umcProject.study.domain.Store;
import umcProject.study.web.dto.StoreRegisterRequestDTO;

public interface StoreCommandService {

    public Store RegisterStore(StoreRegisterRequestDTO.RegisterDTO request);
}
