package com.movieflix.controller.request;

import lombok.Builder;
import lombok.experimental.UtilityClass;

@Builder
public record UserRequest(
        String name,
        String email,
        String password
) {
}
