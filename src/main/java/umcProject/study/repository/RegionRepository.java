package umcProject.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcProject.study.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
