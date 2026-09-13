package com.ebac.idempotent_user_api.controller;

import com.ebac.idempotent_user_api.dto.UserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Endpoint para gerenciamento de usuários")
public class UserController {

    private final Set<UserRequest> usersDatabase = new CopyOnWriteArraySet<>();

    @PostMapping
    @Operation(summary = "Cria um novo usuário", description = "Endpoint idempotente: requisições idênticas repetidas não duplicam o registro, mas retornam 201 Created.")
    public ResponseEntity<UserRequest> createUser(@Valid @RequestBody UserRequest request) {

        usersDatabase.add(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }
}
