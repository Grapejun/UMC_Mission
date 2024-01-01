package umcProject.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcProject.study.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
