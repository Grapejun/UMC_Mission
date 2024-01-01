package umcProject.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcProject.study.apiPayload.code.status.ErrorStatus;
import umcProject.study.apiPayload.exception.handler.ReviewHandler;
import umcProject.study.domain.*;
import umcProject.study.repository.MemberRepository;
import umcProject.study.repository.ReviewRepository;
import umcProject.study.repository.StoreRepository;
import umcProject.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review registerReview(ReviewRequestDTO.ReviewDTO request) {


        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(RuntimeException::new);

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new ReviewHandler(ErrorStatus.STORE_NOT_FOUND));

        Review newReview = Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();

        member.getReviewList().add(newReview);


        return reviewRepository.save(newReview);
    }
}
