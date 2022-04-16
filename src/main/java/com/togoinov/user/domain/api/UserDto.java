package com.togoinov.user.domain.api;

import com.togoinov.user.api.Sex;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Builder(toBuilder = true)
@Data
@Value

public class UserDto {
    @Nullable
    UUID id;

    @Schema(
            example = "Jeff"
    )
    @NonNull
    @NotNull
    String firstname;

    @Schema(
            example = "Sutherland"
    )
    @NonNull
    @NotNull
    String lastname;

    @Schema(
            example = "Male, female, etc"
    )
    @NonNull
    @NotNull
    Sex sex;

    @Schema(
            example = "01.01.2014"
    )
    @NonNull
    @NotNull
    String dob;

    @Schema(
            example = "ab@cd.com"
    )
    @NonNull
    @NotNull
    String email;

    @Schema(
            description = "Avatar"
    )
    @NonNull
    @NotNull
    String avatar;

    @Schema(
            description = "address list"
    )
    @Nullable
    @Singular(ignoreNullCollections = true)
    List<AddressDto> addressDtos;
}
