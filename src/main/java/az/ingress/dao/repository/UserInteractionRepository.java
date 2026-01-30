package az.ingress.dao.repository;

import az.ingress.dao.entity.UserInteractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInteractionRepository extends JpaRepository<UserInteractionEntity, Long> {
    List<UserInteractionEntity> findByUserId(Long userId);
}
