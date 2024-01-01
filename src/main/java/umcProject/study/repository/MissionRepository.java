package umcProject.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcProject.study.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
