package umcProject.study.converter;

import umcProject.study.domain.FoodCategory;
import umcProject.study.domain.Region;
import umcProject.study.domain.Store;
import umcProject.study.web.dto.StoreRegisterRequestDTO;
import umcProject.study.web.dto.StoreRegisterResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StoreConverter {

    public static StoreRegisterResponseDTO.RegisterResultDTO registerResultDTO(Store store) {
        return StoreRegisterResponseDTO.RegisterResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // 지역명과 카테고리 이름은 실제로 바꿔야 함.
}
