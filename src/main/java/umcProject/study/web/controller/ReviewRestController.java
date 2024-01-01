package umcProject.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcProject.study.apiPayload.ApiResponse;
import umcProject.study.converter.ReviewConverter;
import umcProject.study.domain.Review;
import umcProject.study.service.ReviewService.ReviewCommandService;
import umcProject.study.web.dto.ReviewRequestDTO;
import umcProject.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> register(@RequestBody @Valid ReviewRequestDTO.ReviewDTO request) {

        Review review = reviewCommandService.registerReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }
}
