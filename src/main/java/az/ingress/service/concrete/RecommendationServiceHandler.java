package az.ingress.service.concrete;

import az.ingress.dao.entity.UserInteractionEntity;
import az.ingress.dao.repository.UserInteractionRepository;
import az.ingress.model.policy.ActionWeightProvider;
import az.ingress.model.response.RecommendationResponse;
import az.ingress.service.abstraction.RecommendationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecommendationServiceHandler implements RecommendationService {
    private final UserInteractionRepository interactionRepository;

    @Override
    public List<RecommendationResponse> getRecommendations(Long userId) {
        List<UserInteractionEntity> interactions = interactionRepository.findByUserId(userId);

        Map<Long, Integer> scoreMap = new HashMap<>();

        for (UserInteractionEntity interaction : interactions) {
            int weight = ActionWeightProvider.getWeight(interaction.getAction());

            scoreMap.merge(
                    interaction.getParentId(),
                    weight,
                    Integer::sum
            );
        }

        return scoreMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Long, Integer>comparingByValue().reversed())
                .limit(10)
                .map(entry -> RecommendationResponse.builder()
                        .parentId(entry.getKey().toString())
                        .build()
                )
                .toList();
    }
}
