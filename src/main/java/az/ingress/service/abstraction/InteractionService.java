package az.ingress.service.abstraction;

import az.ingress.model.dto.RecommendationEventDTO;

public interface InteractionService {
    void save(RecommendationEventDTO recommendationEventDTO);
}
