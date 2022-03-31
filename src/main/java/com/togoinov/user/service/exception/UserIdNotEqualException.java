package com.togoinov.user.service.exception;

import com.togoinov.user.common.StructuredArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

import java.util.UUID;

import static com.togoinov.user.common.LogConstants.LOG_FORMAT_3;

@Slf4j
public class UserIdNotEqualException extends RuntimeException {
    public UserIdNotEqualException(@Nullable UUID one, @Nullable UUID two) {
        super("User Id is not equal. userIdOne=" + one + ", userIdTwo=" + two);

        log.warn(
                LOG_FORMAT_3,
                this.getMessage(),
                StructuredArgs.id(one),
                StructuredArgs.id(two)
        );
    }
}
