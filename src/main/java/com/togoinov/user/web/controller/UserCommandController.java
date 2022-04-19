package com.togoinov.user.web.controller;

import com.togoinov.user.api.UserDto;
import com.togoinov.user.api.service.UserCommandService;
import com.togoinov.user.common.StructuredArgs;
import com.togoinov.user.service.exception.UserIdNotEqualException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

import static com.togoinov.user.common.LogConstants.LOG_FORMAT_2;

@Tag(
        name = "User Command",
        description = "Représente les opérations de mutation des ressources 'User'"
)
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/users")
@Validated
public class UserCommandController {

    @NonNull
    private final UserCommandService userCommandService;

    @Operation()
    @PostMapping("")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "created")
    })
    @NonNull
    public ResponseEntity<UserDto> createUser(
            @Valid @RequestBody @NonNull final UserDto userDto
    ) {
        log.info(
                LOG_FORMAT_2,
                "API: Creating User",
                StructuredArgs.userDto(userDto)
        );
        final var newUserDto = userCommandService.create(userDto);
        log.info(
                LOG_FORMAT_2,
                "API: User Created",
                StructuredArgs.userDto(newUserDto)
        );
        return createResponseBody(newUserDto);
    }

    @Operation()
    @DeleteMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Deleted")
    })
    public void deleteUser(@PathVariable(name = "id") @NonNull final UUID id) {
        log.info(
                LOG_FORMAT_2,
                "API: Deleting User",
                StructuredArgs.id(id)
        );
        userCommandService.delete(id);
    }

    @Operation()
    @PutMapping("/{id}")
    public @NonNull UserDto updateUser(
            @PathVariable(name = "id", required = true) @NonNull UUID id,
            @Valid @RequestBody @NonNull final UserDto userDto
    ) {
        if (! id.equals(userDto.getId())) {
            throw new UserIdNotEqualException(id, userDto.getId());
        }
        log.info(
                LOG_FORMAT_2,
                "API: Updating User",
                StructuredArgs.userDto(userDto)
        );
        return userCommandService.update(userDto);
    }

    private @NonNull ResponseEntity<UserDto> createResponseBody(@NonNull final UserDto userDto) {
        return ResponseEntity.created(
                URI.create("/api/users" + userDto.getId())
        ).body(userDto);
    }
}
