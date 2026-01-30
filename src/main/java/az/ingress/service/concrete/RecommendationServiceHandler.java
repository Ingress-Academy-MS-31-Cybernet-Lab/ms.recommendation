package az.ingress.service.concrete;

import az.ingress.dao.repository.UserInteractionRepository;
import az.ingress.service.abstraction.RecommendationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecommendationServiceHandler implements RecommendationService {

    private final UserInteractionRepository interactionRepository;

    @Override
    public void recalculate(Long userId) {
        log.info("ActionLog.RecommendationServiceHandler.recalculate.start: param={}", userId);
        // todo
    }
}
