package az.ingress.mapper;

import az.ingress.dao.entity.UserInteractionEntity;
import az.ingress.model.dto.RecommendationEventDTO;

import java.util.List;

public enum RecommendationMapper {
    RECOMMENDATION_MAPPER;

    public UserInteractionEntity buildEntity(RecommendationEventDTO recommendationEventDTO) {
        return UserInteractionEntity.builder()
                .userId(recommendationEventDTO.getUserId())
                .parentId(recommendationEventDTO.getParentId())
                .action(recommendationEventDTO.getAction())
                .eventTime(recommendationEventDTO.getEventTime())
                .build();
    }

    public List<RecommendationEventDTO> buildDTOList(List<UserInteractionEntity> entities) {
        return entities.stream()
                .map(e -> new RecommendationEventDTO(
                        e.getUserId(),
                        e.getParentId(),
                        e.getAction(),
                        e.getEventTime()
                ))
                .toList();
    }
}
