package az.ingress.model.policy;

import az.ingress.model.enums.ActionType;

import java.util.EnumMap;
import java.util.Map;

public final class ActionWeightProvider {

    private static final Map<ActionType, Integer> WEIGHTS =
            new EnumMap<>(ActionType.class);

    static {
        WEIGHTS.put(ActionType.ORDER_COMPLETED, 3);
        WEIGHTS.put(ActionType.ADD_TO_CART, 2);
        WEIGHTS.put(ActionType.ADD_TO_WISHLIST, 1);
    }

    private ActionWeightProvider() {
    }

    public static int getWeight(ActionType actionType) {
        return WEIGHTS.getOrDefault(actionType, 0);
    }
}