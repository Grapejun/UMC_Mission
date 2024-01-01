package umcProject.study.service.ReviewService;

import umcProject.study.domain.Review;
import umcProject.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    public Review registerReview(ReviewRequestDTO.ReviewDTO request);
}
