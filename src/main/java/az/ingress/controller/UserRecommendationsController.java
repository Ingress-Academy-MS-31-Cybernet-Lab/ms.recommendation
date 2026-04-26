package az.ingress.controller;

import az.ingress.model.response.RecommendationResponse;
import az.ingress.service.abstraction.UserRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static az.ingress.model.constants.HeaderConstants.USER_ID_HEADER;

@RestController
@RequestMapping("/v1/user-recommendations")
@RequiredArgsConstructor
public class UserRecommendationsController {
    private final UserRecommendationService userRecommendationService;

    @GetMapping
    public List<RecommendationResponse> getRecommendations(@RequestHeader(USER_ID_HEADER) Long userId) {
        return userRecommendationService.getRecommendations(userId);
    }
}
