package com.social.workshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull String id, @NotBlank String name, @NotBlank String email) {
}
