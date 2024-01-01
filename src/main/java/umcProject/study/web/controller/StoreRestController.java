package umcProject.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcProject.study.apiPayload.ApiResponse;
import umcProject.study.converter.StoreConverter;
import umcProject.study.domain.Store;
import umcProject.study.service.StoreService.StoreCommandService;
import umcProject.study.web.dto.StoreRegisterRequestDTO;
import umcProject.study.web.dto.StoreRegisterResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    // 1. 특정 지역에 가게 추가하기 API
    @PostMapping("/")
    public ApiResponse<StoreRegisterResponseDTO.RegisterResultDTO> register(@RequestBody @Valid StoreRegisterRequestDTO.RegisterDTO request) {

        Store store = storeCommandService.RegisterStore(request);
        return ApiResponse.onSuccess(StoreConverter.registerResultDTO(store));

    }


    // 2. 가게에 리뷰 추가하기 API

    // 3. 가게에 미션 추가하기 API


}
