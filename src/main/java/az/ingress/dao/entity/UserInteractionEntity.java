package az.ingress.dao.entity;

import az.ingress.model.enums.ActionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_interactions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInteractionEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Long userId;

    private Long parentId;

    @Enumerated(STRING)
    private ActionType action;

    private LocalDateTime eventTime;
}
