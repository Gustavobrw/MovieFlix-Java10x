package com.movieflix.controller.response;

import lombok.Builder;
import lombok.experimental.UtilityClass;

@Builder
public record UserResponse(
        Long id,
        String name,
        String email
) {
}
