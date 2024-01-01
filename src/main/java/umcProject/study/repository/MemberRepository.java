package umcProject.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcProject.study.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
