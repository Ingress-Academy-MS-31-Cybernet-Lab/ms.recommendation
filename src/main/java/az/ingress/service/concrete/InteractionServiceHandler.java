package az.ingress.service.concrete;

import az.ingress.dao.repository.UserInteractionRepository;
import az.ingress.model.dto.RecommendationEventDTO;
import az.ingress.service.abstraction.InteractionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static az.ingress.mapper.RecommendationMapper.RECOMMENDATION_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class InteractionServiceHandler implements InteractionService {

    private final UserInteractionRepository userInteractionRepository;

    @Override
    public void save(RecommendationEventDTO recommendationEventDTO) {
        log.info("ActionLog.InteractionServiceHandler.save.start: param={}", recommendationEventDTO);

        var interaction = RECOMMENDATION_MAPPER.buildEntity(recommendationEventDTO);
        userInteractionRepository.save(interaction);
    }
}
