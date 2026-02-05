package az.ingress.service.abstraction;

import az.ingress.model.dto.RecommendationQueueDTO;

public interface InteractionService {
    void save(RecommendationQueueDTO recommendationQueueDTO);
}
