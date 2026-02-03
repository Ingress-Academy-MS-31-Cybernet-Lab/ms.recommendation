package az.ingress.service.abstraction;

import az.ingress.model.response.RecommendationResponse;

import java.util.List;

public interface RecommendationService {
    List<RecommendationResponse> getRecommendations(Long userId);
}
