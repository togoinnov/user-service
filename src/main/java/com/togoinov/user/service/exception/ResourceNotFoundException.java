package com.togoinov.user.service.exception;

import com.togoinov.user.common.StructuredArgs;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import static com.togoinov.user.common.LogConstants.LOG_FORMAT_2;

@Slf4j
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(@NonNull final UUID id) {
        super("Resource not found for id=" + id);
        log.warn(LOG_FORMAT_2, this.getMessage(), StructuredArgs.id(id));
    }
}
