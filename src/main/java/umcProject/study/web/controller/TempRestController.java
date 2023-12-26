package umcProject.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umcProject.study.apiPayload.ApiResponse;
import umcProject.study.converter.TempConverter;
import umcProject.study.service.TempService.TempQueryService;
import umcProject.study.web.dto.TempResponse;


@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor // final 선언 필드 혹은 @NonNull 어노테이션이 붙은 필드를 인자로 받는 생성자를 생성
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI() {
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag) {
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}
