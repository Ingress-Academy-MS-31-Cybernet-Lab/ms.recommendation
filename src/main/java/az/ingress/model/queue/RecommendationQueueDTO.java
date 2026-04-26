package az.ingress.model.queue;

import az.ingress.model.enums.ActionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationQueueDTO {
    private Long userId;
    private Long categoryId;
    private ActionType action;
    private LocalDateTime eventTime;
}
