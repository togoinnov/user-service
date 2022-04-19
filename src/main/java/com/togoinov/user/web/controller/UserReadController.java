package com.togoinov.user.web.controller;

import com.togoinov.user.api.UserDto;
import com.togoinov.user.api.service.UserQueryService;
import com.togoinov.user.common.StructuredArgs;
import com.togoinov.user.domain.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.togoinov.user.common.LogConstants.LOG_FORMAT_1;
import static com.togoinov.user.common.LogConstants.LOG_FORMAT_2;

@Tag(
        name = "User Query",
        description = "Représente les opérations de sélection des ressources 'User'"
)
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/users")
@Validated
public class UserReadController {

    @NonNull
    private final UserQueryService userQueryService;

    @Operation()
    @GetMapping("")
    @NonNull
    public ResponseEntity<List<User>> findAllUser() {
        log.info(
                LOG_FORMAT_1,
                "API: Find All Users"
        );
        final var users = userQueryService.findAllUsers();

        return ResponseEntity.status(HttpStatus.OK)
                .body(users);
    }

    @Operation()
    @GetMapping("/paginated")
    @NonNull
    public ResponseEntity<List<User>> findAllUsersPaginated(
            @PageableDefault(size = 15) @NonNull final Pageable pageable
    ) {
        log.info(
                LOG_FORMAT_1,
                "API: Find All Users paginated"
        );
        final var totalElements = userQueryService.countUsers();

        final var headers = new HttpHeaders();
        headers.add("X-Total-Elements", "" + totalElements);

        final var users = userQueryService.findAllUsers();

        return ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body(users);
    }

    @Operation()
    @GetMapping("/{id}")
    @NonNull
    public UserDto getByUserId(
            @PathVariable(name = "id") @NonNull final UUID id
    ) {
        log.info(
                LOG_FORMAT_2,
                "API: Find User by id",
                StructuredArgs.id(id)
        );
        return userQueryService.getUserById(id);
    }
}
