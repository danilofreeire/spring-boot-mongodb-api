package com.social.workshop.dto;

import com.social.workshop.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull String id, @NotBlank String name, @NotBlank String email) {
    public UserDTO() {
        this("defaultId", "defaultName", "defaultEmail");
    }

    public UserDTO(User user) {
        this(user.getId(),user.getName(),user.getEmail());
    }


}
