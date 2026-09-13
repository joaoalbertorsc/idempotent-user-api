package com.ebac.idempotent_user_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotNull(message = "O nome é obrigatório.")
        @Size(min = 3, message = "O nome deve ter pelo menos 3 caracteres.")
        String nome,

        @NotNull(message = "A idade é obrigatória.")
        @Positive(message = "A idade deve ser um número positivo.")
        Integer idade
) {}
