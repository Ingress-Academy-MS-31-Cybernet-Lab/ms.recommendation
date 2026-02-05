package az.ingress.mapper;

import az.ingress.dao.entity.UserInteractionEntity;
import az.ingress.model.dto.RecommendationQueueDTO;

public enum RecommendationMapper {
    RECOMMENDATION_MAPPER;

    public UserInteractionEntity buildEntity(RecommendationQueueDTO recommendationQueueDTO) {
        return UserInteractionEntity.builder()
                .userId(recommendationQueueDTO.getUserId())
                .categoryId(recommendationQueueDTO.getCategoryId())
                .action(recommendationQueueDTO.getAction())
                .eventTime(recommendationQueueDTO.getEventTime())
                .build();
    }
}
