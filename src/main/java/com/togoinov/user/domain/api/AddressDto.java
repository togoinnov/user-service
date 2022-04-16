package com.togoinov.user.domain.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Builder(toBuilder = true)
@Data
@Value
public class AddressDto {
    @Nullable
    UUID id;

    @Schema(
            example = "Avenue de la Libération prolongée"
    )

    @NonNull
    @NotNull
    String street;

    @Schema(
            example = "15"
    )
    @Nullable
    String houseNumber;

    @Schema(
            example = "3174"
    )
    @Nullable
    String zipCode;

    @Schema(
            example = "Lome"
    )
    @NonNull
    @NotNull
    String city;

    @Schema(
            example = "Togo"
    )
    @NonNull
    @NotNull
    String land;
}
