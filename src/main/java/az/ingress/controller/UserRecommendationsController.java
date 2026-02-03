package az.ingress.controller;

import az.ingress.model.response.RecommendationResponse;
import az.ingress.service.abstraction.UserRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserRecommendationsController {
    private final UserRecommendationService userRecommendationService;

    @GetMapping("/{userId}/recommendations")
    public List<RecommendationResponse> getRecommendations(@PathVariable Long userId) {
        return userRecommendationService.getRecommendations(userId);
    }
}
