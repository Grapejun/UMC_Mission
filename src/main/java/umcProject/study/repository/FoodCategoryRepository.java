package umcProject.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcProject.study.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
