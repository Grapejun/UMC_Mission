package umcProject.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcProject.study.apiPayload.code.status.ErrorStatus;
import umcProject.study.apiPayload.exception.handler.FoodCategoryHandler;
import umcProject.study.apiPayload.exception.handler.RegionHandler;
import umcProject.study.converter.StoreConverter;
import umcProject.study.domain.FoodCategory;
import umcProject.study.domain.Region;
import umcProject.study.domain.Store;
import umcProject.study.repository.FoodCategoryRepository;
import umcProject.study.repository.RegionRepository;
import umcProject.study.repository.StoreRepository;
import umcProject.study.web.dto.StoreRegisterRequestDTO;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store RegisterStore(StoreRegisterRequestDTO.RegisterDTO request) {

        FoodCategory foodCategory = foodCategoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));

        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));


        Store newStore = Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score((float) 0)
                .MissionList(new ArrayList<>())
                .region(region)
                .foodCategory(foodCategory)
                .build();

        region.RegisterStore(newStore);
//        System.out.println("가게가 지역에 등록되었습니다.");

        return storeRepository.save(newStore);
    }

}
