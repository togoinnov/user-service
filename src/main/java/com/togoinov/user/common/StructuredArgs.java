package com.togoinov.user.common;

import com.togoinov.user.api.UserDto;
import com.togoinov.user.domain.entities.User;
import lombok.NonNull;
import net.logstash.logback.argument.StructuredArgument;
import net.logstash.logback.argument.StructuredArguments;

import java.util.UUID;

public class StructuredArgs {

    private StructuredArgs(){}

    public static @NonNull StructuredArgument keyValue(
            final @NonNull String key,
            final @NonNull Object value
    ) {
        return StructuredArguments.keyValue(key, value);
    }

    public static @NonNull StructuredArgument user(final @NonNull User user) {
        return keyValue("userDto", user);
    }

    public static @NonNull StructuredArgument userDto(final @NonNull UserDto userDto) {
        return keyValue("userDto", userDto);
    }

    public static @NonNull StructuredArgument  id(final @NonNull UUID id) {
        return keyValue("id", id);
    }
}
