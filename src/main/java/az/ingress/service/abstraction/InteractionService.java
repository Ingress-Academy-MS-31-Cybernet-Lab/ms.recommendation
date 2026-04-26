package az.ingress.service.abstraction;

import az.ingress.model.queue.RecommendationQueueDTO;

public interface InteractionService {
    void save(RecommendationQueueDTO recommendationQueueDTO);
}
