package az.ingress.queue;

import az.ingress.exception.QueueException;
import az.ingress.model.dto.RecommendationEventDTO;
import az.ingress.service.abstraction.InteractionService;
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
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${rabbitmq.queue.recommendation}")
    public void handle(String message) {
        try {
            var recommendationEvent = objectMapper.readValue(message, RecommendationEventDTO.class);

            interactionService.save(recommendationEvent);
        } catch (JsonProcessingException e) {
            log.error("ActionLog.TestListener.handle.failed: invalid format={}", message);
        } catch (Exception e) {
            throw new QueueException();
        }
    }
}
