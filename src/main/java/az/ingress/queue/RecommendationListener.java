package az.ingress.queue;

import az.ingress.model.dto.RecommendationEventDTO;
import az.ingress.service.abstraction.InteractionService;
import az.ingress.service.abstraction.RecommendationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RecommendationListener {
    private final InteractionService interactionService;
    private final RecommendationService recommendationService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${rabbitmq.queue.recommendation}")
    public void handle(String message) {
        try {
            var recommendationEvent = objectMapper.readValue(message, RecommendationEventDTO.class);

            interactionService.save(recommendationEvent);
            recommendationService.recalculate(recommendationEvent.getUserId());
        } catch (JsonProcessingException e) {
            log.error("ActionLog.TestListener.handleV2.failed: invalid format={}", message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
