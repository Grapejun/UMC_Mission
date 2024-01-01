package umcProject.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcProject.study.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
